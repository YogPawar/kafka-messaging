package com.yogsfot.kafkatut.producer;

import com.yogsfot.kafkatut.payload.UserPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

  public static Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

  private KafkaTemplate<String, UserPayload> kafkaTemplate;

  public JsonKafkaProducer(KafkaTemplate<String, UserPayload> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(UserPayload user) {
    log.info("Message sent -> {}", user);

    Message<UserPayload> message = MessageBuilder.withPayload(user)
        .setHeader(KafkaHeaders.TOPIC, "tutotopic").build();
    kafkaTemplate.send(message);
  }

}
