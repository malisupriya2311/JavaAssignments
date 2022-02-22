package com.example.demo.controller;

import com.example.demo.constants.Constant;
import com.example.demo.service.interfaces.IPerfectNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfectNumberConroller {
    @Autowired
    private IPerfectNumberService perfectNumberService;

    @RequestMapping("/perfectNumber/{number}")
    public String findPerfectNumber(@PathVariable int number){
        return perfectNumberService.findPerfectNo(number, Constant.INDEX,Constant.ADDITION);
    }

    @RequestMapping("/perfectNumber/from/{startNo}/to/{endNo}")
    public String findPerfectNoBtwRange(@PathVariable int startNo, @PathVariable int endNo){
        return perfectNumberService.findPerfectNoBtwRange(startNo,endNo,1);
    }
}
