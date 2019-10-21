package com.example.springlearn;

import com.example.springlearn.video3_bean.HelloBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringLearnApplicationTests {



    @Test
    void contextLoads() {
    }

    @Test
    void testVideo2_bean(HelloBean helloBean){

        assertThat(helloBean).isEqualTo("");

    }

}
