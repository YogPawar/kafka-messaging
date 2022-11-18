package com.yogsfot.kafkatut.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserPayload {

  private int id;
  private String firstName;
  private String lastName;

}
