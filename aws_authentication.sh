#!/usr/bin/env bash
set -e


# Login to AWS

echo 'Setting up AWS id, key and region'
export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY
export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_KEY
export AWS_DEFAULT_REGION=$AWS_REGION