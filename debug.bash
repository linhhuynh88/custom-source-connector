
export KAFKA_DEBUG="y"
/Users/linhhuynh/Downloads/confluent-5.5.1/bin/connect-standalone /Users/linhhuynh/custom-source-connector/config/connect-avro-docker.properties /Users/linhhuynh/custom-source-connector/config/MySourceConnector.properties
#unset $KAFKA_DEBUG