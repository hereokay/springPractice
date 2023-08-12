package com.example.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonServiceTest {

    @Test
    @DisplayName("스프링 없이 싱글톤 구현")
    void singletonTest(){
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();


        Assertions.assertThat(instance1).isSameAs(instance2);
    }


}
