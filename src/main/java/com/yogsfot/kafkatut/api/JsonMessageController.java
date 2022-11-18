  package com.yogsfot.kafkatut.api;

  import com.yogsfot.kafkatut.payload.UserPayload;
  import com.yogsfot.kafkatut.producer.JsonKafkaProducer;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.ResponseEntity;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;

  @RestController
  @RequestMapping("/api/v1/kafka")
  public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody UserPayload user) {
      jsonKafkaProducer.sendMessage(user);
      return ResponseEntity.ok("Json message sent successfully");
    }
  }
