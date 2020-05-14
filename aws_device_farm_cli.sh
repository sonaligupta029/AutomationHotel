#!/usr/bin/env bash
set -e


AWS_ARN_PROJECT="arn:aws:devicefarm:us-west-2:605536185498:project:1c88132b-44fc-4830-84fd-81e0cb97a5e7"
APK_NAME="app-armeabi-v7a-release.apk"
ZIP_NAME="zip-with-dependencies.zip"
ZIP_TYPE="APPIUM_JAVA_TESTNG_TEST_PACKAGE"
APP_TYPE="ANDROID_APP"
AWS_REGION="us-west-2"
AWS_DEVICE_POOL_ARN="arn:aws:devicefarm:us-west-2:605536185498:devicepool:1c88132b-44fc-4830-84fd-81e0cb97a5e7/23786a28-45aa-47dd-a455-9a786daf85ee"

# Build the Test ZIP File
cd $BITRISE_SOURCE_DIR/cybertron-starscream/appautomation
mvn clean package -DskipTests=true

# Upload Test ZIP file
cd $BITRISE_SOURCE_DIR/cybertron-starscream/appautomation/target
ZIP_JSON=$(aws devicefarm create-upload --project-arn "$AWS_ARN_PROJECT" --name $ZIP_NAME --type $ZIP_TYPE --region=$AWS_REGION)
ZIP_URL=$(echo $ZIP_JSON | jq '.upload.url' | tr -d '"')
ZIP_ARN=$(echo $ZIP_JSON | jq '.upload.arn' | tr -d '"')
curl -T zip-with-dependencies.zip "$ZIP_URL"

#Hardcoding wait to check if the workflow is fine
echo 'start sleep for zip upload'
sleep 60
echo 'stop sleep for zip upload'

# Get ZIP Upload Status
aws devicefarm get-upload --arn "$ZIP_ARN" --region=$AWS_REGION

# Upload APK to Device Farm
cd $BITRISE_SOURCE_DIR/cybertron-starscream/android/app/build/outputs/apk/
APK_JSON=$(aws devicefarm create-upload --project-arn "$AWS_ARN_PROJECT" --name $APK_NAME --type $APP_TYPE --region=$AWS_REGION)
APK_URL=$(echo $APK_JSON | jq '.upload.url' | tr -d '"')
APK_ARN=$(echo $APK_JSON | jq '.upload.arn' | tr -d '"')
curl -T app-armeabi-v7a-release.apk "$APK_URL"

echo 'start sleep for apk upload'
sleep 10
echo 'stop sleep for apk upload'

# Rename the apk and upload it to s3
date_format=$(date +"%d_%h_%y_%H_%M")
mv app-armeabi-v7a-release.apk "$date_format".apk
aws s3 cp "$date_format".apk s3://treebo/app/apk/



# Get APK Upload Status
aws devicefarm get-upload --arn "$APK_ARN" --region=$AWS_REGION

# Schedule the test cases to run in device farm
SCHEDULE_JSON=$(aws devicefarm schedule-run --project-arn "$AWS_ARN_PROJECT" --app-arn "$APK_ARN" --device-pool-arn "$AWS_DEVICE_POOL_ARN" --name "Native_App" --test '{"type": "APPIUM_JAVA_TESTNG","testPackageArn":"'"${ZIP_ARN}"'"}' --region=$AWS_REGION)

SCHEDULE_ARN=$(echo $SCHEDULE_JSON | jq '.run.arn' | tr -d '"')

# To get the status of scheduled test cases in device farm
aws devicefarm get-run --arn "$SCHEDULE_ARN" --region=$AWS_REGION