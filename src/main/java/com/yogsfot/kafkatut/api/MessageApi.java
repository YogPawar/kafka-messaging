package com.yogsfot.kafkatut.api;

import com.yogsfot.kafkatut.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageApi {

  private KafkaProducer kafkaProducer;

  //here we are avoiding autowired annotation as we have only one parameterized constructor.
  public MessageApi(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  //http://localhost:8080/api/v1/kafka/publish?message="Yo YO"
  @GetMapping("/publish")
  public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message Send Successfully");
  }

}
