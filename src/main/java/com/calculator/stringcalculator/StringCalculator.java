package com.calculator.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private int addCounter = 0;
    public int add(String numberString) {
            addCounter++;
            if (null == numberString || numberString.isEmpty()) return 0;

            String delimiter = ",|\n";
            if (numberString.startsWith("//")) {
                int newlineIndex = numberString.indexOf("\n");
//                delimiter = numberString.substring(2, newlineIndex);
                String delimiterPart = numberString.substring(2, newlineIndex);
                numberString = numberString.substring(newlineIndex + 1);

                if(delimiterPart.startsWith("[") && delimiterPart.endsWith("]")){
                    List<String> delimiters = new ArrayList<>();
                    Matcher m = Pattern.compile("\\[(.*?)]").matcher(delimiterPart);
                    while(m.find())
                        delimiters.add(Pattern.quote(m.group(1)));
                    delimiter = String.join("|", delimiters);
                } else {
                    delimiter = Pattern.quote(delimiterPart);
                    System.out.println(delimiterPart);
                }
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
