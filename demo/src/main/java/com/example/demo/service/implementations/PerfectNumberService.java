package com.example.demo.service.implementations;

import com.example.demo.constants.Constant;
import com.example.demo.service.interfaces.IPerfectNumberService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class PerfectNumberService implements IPerfectNumberService {
    static Set<Integer> listOfPerfectNo = new TreeSet<>();

    @Override
    public String findPerfectNo(int number, int index, int addition) {
        if (index <= number / 2) {
            if (number % index == 0) {
                addition = addition + index;
            }
            index++;
            return findPerfectNo(number, index, addition);
        }
        return isPerfectNum(number,addition);
    }

    public String isPerfectNum(int number, long addition) {
        if(number == addition){
            return number +Constant.PERFECT_NO;
        } else{
            return number + Constant.NOT_PERFECT_NO;
        }
    }
    @Override
    public String findPerfectNoBtwRange(int firstNo, int lastNo, int addition){
        listOfPerfectNo.clear();
        if(lastNo > firstNo) {
            for (int perfectNo = firstNo; perfectNo < lastNo; perfectNo++) {
                if (isPerfectNo(perfectNo,addition)) {
                    listOfPerfectNo.add(perfectNo);
                }
            }
        } else {
            return Constant.INVALID_NUMBER;
        }
        return isPerfectNumBtwRange();
    }

    private String isPerfectNumBtwRange() {
        if(listOfPerfectNo.size() > 0){
            return Constant.PERFECT_NO_IS+ listOfPerfectNo;
        } else {
            return Constant.PERFECT_NO_NOT_PRESENT;
        }
    }

    public static boolean isPerfectNo(int num,int addition){
        //int addition = 1;
        for (int index = 2; index * index <= num; index++)
        {
            if (num % index==0)
            {
                if(index * index != num)
                    addition = addition + index + num / index;
                else
                    addition = addition + index;
            }
        }
        if (addition == num && num != 1) {
            return true;
        }
        return false;
    }
}
