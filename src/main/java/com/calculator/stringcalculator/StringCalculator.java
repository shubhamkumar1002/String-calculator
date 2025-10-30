package com.calculator.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private int addCounter = 0;
    public int add(String numberString) {
            addCounter++;
            if (null == numberString || numberString.isEmpty()) return 0;

            String delimiter = ",|\n";
            if (numberString.startsWith("//")) {
                int newlineIndex = numberString.indexOf("\n");
                delimiter = numberString.substring(2, newlineIndex);
                numberString = numberString.substring(newlineIndex + 1);
            }
            List<Integer> negativeNumberList = new ArrayList<>();
            String[] parts = numberString.split(delimiter);
            int sum = 0;
            for (String part : parts) {
                int number = Integer.parseInt(part.trim());
                if(number<0){
                    negativeNumberList.add(number);
                }
                sum += number<=1000?number:0;
            }

            if(!negativeNumberList.isEmpty()){
                throw new IllegalArgumentException("negatives not allowed "+negativeNumberList);
            }
            return sum;

    }

    public int getAddCounter() {
        return addCounter;
    }
}
