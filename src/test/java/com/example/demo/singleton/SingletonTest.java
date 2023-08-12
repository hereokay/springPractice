package com.example.demo.singleton;

import com.example.demo.AppConfig;
import com.example.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {


    @Test
    @DisplayName("스프링 업는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }
}
