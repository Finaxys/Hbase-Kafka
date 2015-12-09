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
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master01.cl02.sr.x2p.fr:6667");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        /*props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);*/
        producer = new KafkaProducer(props);
        LOG.info("producer created");
        System.out.println("producer created");
    }

    public void send(){
        String key = "mykey";
        String value = "myvalue";
        System.out.println("start sending");
        System.out.println(producer.send(new ProducerRecord<String, String>(topic, key, value)));
        System.out.println("sent");
    }

    public void close(){
        producer.close();
    }
}
