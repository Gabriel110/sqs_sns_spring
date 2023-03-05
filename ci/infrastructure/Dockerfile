FROM localstack/localstack:0.11.2

COPY local /opt/bootstrap/
COPY --chown=root:root local/aws/configuration /root/.aws/config
COPY --chown=root:root local/aws/cred-local /root/.aws/credentials

ENV DYNAMODB_PORT="4569"
ENV WIREMOCK_PORT="8882"

RUN chmod +x /opt/bootstrap/cli/setup-sqs.sh && sed -i -e 's/\r$//' /opt/bootstrap/cli/setup-sqs.sh
RUN chmod +x /opt/bootstrap/cli/setup-sns.sh && sed -i -e 's/\r$//' /opt/bootstrap/cli/setup-sns.sh
RUN chmod +x /opt/bootstrap/cli/setup-dynamodb.sh && sed -i -e 's/\r$//' /opt/bootstrap/cli/setup-dynamodb.sh
RUN chmod +x /opt/bootstrap/cli/bootstrap.sh && sed -i -e 's/\r$//' /opt/bootstrap/cli/bootstrap.sh

ENTRYPOINT ["/opt/bootstrap/cli/bootstrap.sh"]