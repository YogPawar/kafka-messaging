package com.yogsfot.kafkatut.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

  private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

  //@KafkaListener(topics = "tutotopic", groupId = "myGroup")
  public void listen(String message) {
    logger.info("Received the message {}", message);
  }
}
