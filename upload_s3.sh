#!/usr/bin/env bash
set -e

# Login to AWS
echo 'Setting up AWS id, key and region'
export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY
export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_KEY
export AWS_DEFAULT_REGION=$AWS_REGION

# Navigate to the apk directory
cd $BITRISE_SOURCE_DIR/cybertron-starscream/android/app/build/outputs/apk/
ls -l

# Rename the apk and upload it to s3
date_format=$(date +"%d_%h_%y_%H_%M")
mv app-universal-release.apk "$date_format"_universal.apk
aws s3 cp "$date_format"_universal.apk s3://treebo/app/apk/

mv app-x86-release.apk "$date_format"_x86.apk
aws s3 cp "$date_format"_x86.apk s3://treebo/app/apk/

mv app-armeabi-v7a-release.apk "$date_format"_arm.apk
aws s3 cp "$date_format"_arm.apk s3://treebo/app/apk/


export APK_NAME=$date_format
cd $BITRISE_SOURCE_DIR/appautomation
wget 'https://kx0sm3wddl.execute-api.ap-south-1.amazonaws.com/prod/jenkins/bitrise?JOB_NAME=web-p-direct-devicefarm-singledevice&SUITE_NAME=sanity&APK_NAME='"$APK_NAME"_universal.apk