#!/usr/bin/env sh
unset http_proxy
unset https_proxy
unset HTTP_PROXY
unset HTTPS_PROXY
export no_proxy="wiremock,localstack"
export NO_PROXY="wiremock,localstack"

sed -i '/nodaemon/d' /etc/supervisord.conf
/usr/bin/supervisord -c "/etc/supervisord.conf"

LOCALSTACK_HOST=localhost

waiting_resource(){
    resource=$1
    host=$2
    port=$3
    # shellcheck disable=SC2034
    for i in $host $port; do
        echo "[INFO] - Waiting for resource ${resource} in ${host}:${port}..."
        sleep 1
    done
}

waiting_resource "SNS" $LOCALSTACK_HOST 4575
waiting_resource "SQS" $LOCALSTACK_HOST 4576
waiting_resource "DynamoDb" $LOCALSTACK_HOST $DYNAMODB_PORT

/opt/bootstrap/cli/setup-sns.sh
/opt/bootstrap/cli/setup-dynamodb.sh
/opt/bootstrap/cli/setup-sqs.sh

tail -f /tmp/supervisord.log