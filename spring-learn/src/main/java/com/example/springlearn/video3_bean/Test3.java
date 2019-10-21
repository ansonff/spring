package com.example.springlearn.video3_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test3 {

  @Autowired private HelloBean helloBean;

  public void run() {
    String expect = "id: 1, name: hello";
    System.out.println(this.getClass().getName() + ":");
    System.out.println("expect: " + expect);
    System.out.println("actual: " + helloBean);
  }
}
