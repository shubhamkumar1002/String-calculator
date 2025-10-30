package com.calculator.stringcalculator;

public class StringCalculator {

    public int add(String numbers){
        if( null==numbers ||numbers.isEmpty()) {
            return 0;
        }else {
            return Integer.parseInt(numbers);
        }
    }
}
