package fr.finaxys;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


/**
 * Created by ylegars on 09/12/2015.
 */
public class MessageProducer {
    private final static Logger LOG = LoggerFactory.getLogger(MessageProducer.class);
    private Producer<String, String> producer;
    private String topic;

    public MessageProducer(String theTopic) {

        topic = theTopic;
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(props);
    }

    public void send(){
        String key = "mykey";
        String value = "myvalue";
        producer.send(new ProducerRecord<String, String>(topic, value));
    }

    public void close(){
        producer.close();
    }
}
