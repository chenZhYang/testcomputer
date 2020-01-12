package com.aaronchen.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    AnswerProgramService answerProgramService;
    @Test
    void contextLoads() {
        Integer[] integers = new Integer[]{2,3};
        List<String> list = answerProgramService.dealDigitsMapping(integers);
        System.out.println(list);
    }

}
