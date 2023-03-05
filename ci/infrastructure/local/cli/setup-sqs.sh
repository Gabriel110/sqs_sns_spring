#!/bin/bash

echo 'Cirando queue localhost'
aws sqs create-queue --queue-name create-card-sqs --endpoint-url http://localhost:4566
echo 'Step criacao de queue finalizada com sucesso'

echo 'Verificando filas criadas'
aws sqs list-queues --endpoint-url http://localhost:4566 --no-paginate
echo 'Veficacao finalizada'