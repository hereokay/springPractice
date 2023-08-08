package com.example.demo.beanfind;

import com.example.demo.AppConfig;
import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixDiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("두개의 빈 한번에 조회 X")
    void findBeanByTypeDuplicate(){
        DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
        System.out.println("bean = " + bean);
    }


    @Test
    @DisplayName("타입으로 모두 조회")
    void findBeanByNameDuplicate(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s);
            System.out.println("beansOfType = " + beansOfType.get(s));
        }
        Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscountPolicy();
        }
    }
}
