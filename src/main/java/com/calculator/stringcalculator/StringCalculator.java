package com.calculator.stringcalculator;

public class StringCalculator {

    public int add(String numberString){
        if( null==numberString ||numberString.isEmpty()) {
            return 0;
        }else {
            if(numberString.contains(",")){
                String[] parts = numberString.split("[,|\n]");
                int sum = 0;
                for(String part: parts){
                    sum += Integer.parseInt(part);
                }
                return sum;
            }
            return Integer.parseInt(numberString);
        }
    }
}
