package com.example.springlearn.video4_bean_reference;

import com.example.springlearn.video4_bean_reference.bean.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {

  @Autowired private HelloBean helloBean;

  public void run() {
    String expect = "id: 1, name: hello World";
    System.out.println(this.getClass().getName() + ":");
    System.out.println("expect: " + expect);
    System.out.println("actual: " + helloBean);
  }
}
