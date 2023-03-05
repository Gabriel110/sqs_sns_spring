#!/bin/bash

echo 'Criando tabela de card'
aws dynamodb create-table \
    --endpoint-url="http://localhost:${DYNAMODB_PORT}" \
    --table-name card \
    --attribute-definitions \
        "AttributeName=pk,AttributeType=S" \
        "AttributeName=code,AttributeType=S" \
    --key-schema \
        "AttributeName=pk,KeyType=HASH" \
    --global-secondary-indexes \
        "IndexName=codeIndex,KeySchema=[{AttributeName=code,KeyType=HASH}],Projection={ProjectionType=ALL},ProvisionedThroughput={ReadCapacityUnits=1,WriteCapacityUnits=1}" \
    --provisioned-throughput \
        "ReadCapacityUnits=5,WriteCapacityUnits=5"

echo 'Steep dynamodb encerrado com sucesso '