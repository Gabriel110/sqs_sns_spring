#!/bin/bash

echo 'Criando topico'
aws sns create-topic --name create-card-sns --endpoint-url http://localhost:4575
echo 'Criacao topico finalizada com sucesso'