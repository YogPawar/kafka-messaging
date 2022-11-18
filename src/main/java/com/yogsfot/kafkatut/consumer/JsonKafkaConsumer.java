package com.yogsfot.kafkatut.consumer;

import com.yogsfot.kafkatut.payload.UserPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

  private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

  @KafkaListener(topics = "tutotopic", groupId = "myGroup")
  public void consumeMessage(UserPayload user) {
    logger.info("Message : {}", user);
  }
}
