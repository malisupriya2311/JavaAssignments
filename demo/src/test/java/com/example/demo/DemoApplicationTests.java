package com.example.demo;

import com.example.demo.service.implementations.PerfectNumberService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
    @InjectMocks
    PerfectNumberService iPerfectNumberService;

    @Test
    public void testGivenNoIsPerfectNo(){
        String result = iPerfectNumberService.findPerfectNo(6, 1, 0);
        assertEquals("6 is perfect number", result);
    }

    @Test
    public void testGivenNoIsNotPerfectNo(){
        String result = iPerfectNumberService.findPerfectNo(10, 1, 0);
        assertEquals("10 is not perfect number", result);
    }

    @Test
    public void testPerfectNoBtwRange(){
        String result = iPerfectNumberService.findPerfectNoBtwRange(1,100,1);
        assertEquals("Perfect Numbers are [6, 28]", result);
    }

    @Test
    public void testInvalidInputRange(){
        String result = iPerfectNumberService.findPerfectNoBtwRange(100,2,1);
        assertEquals("Invalid Range, Last number must be greater than first number", result);
    }

}
