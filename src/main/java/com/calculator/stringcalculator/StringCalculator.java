package com.calculator.stringcalculator;

public class StringCalculator {

    public int add(String numberString) {

            if (null == numberString || numberString.isEmpty()) return 0;

            String delimiter = ",|\n";
            if (numberString.startsWith("//")) {
                int newlineIndex = numberString.indexOf("\n");
                delimiter = numberString.substring(2, newlineIndex);
                numberString = numberString.substring(newlineIndex + 1);
            }
            String[] parts = numberString.split(delimiter);
            int sum = 0;
            for (String part : parts) {
                if(Integer.parseInt(part.trim())<0){
                    throw new IllegalArgumentException("negative numbers not allowed "+part);
                }
                sum += Integer.parseInt(part);
            }
            return sum;

    }

}
