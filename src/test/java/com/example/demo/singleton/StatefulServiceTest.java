package com.example.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(StatefulService.class);

        StatefulService bean1 = ac.getBean(StatefulService.class);
        StatefulService bean2 = ac.getBean(StatefulService.class);

        bean1.order("A",1000);
        bean2.order("B",2000);

        Assertions.assertThat(bean1.getPrice()).isEqualTo(2000);

    }


    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}