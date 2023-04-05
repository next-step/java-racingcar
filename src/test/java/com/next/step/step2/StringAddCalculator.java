package com.next.step.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int sum = 0;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] splitNumbers = m.group(2).split(customDelimiter);

            for (String number : splitNumbers) {
                Integer stringToNumber = Integer.parseInt(number);
                if (stringToNumber < 0) {
                    throw new RuntimeException();
                }
                sum += stringToNumber;
            }
        } else {
            String delimiter = ",|:";

            String[] splitNumbers = input.split(delimiter);

            for (String number : splitNumbers) {
                Integer stringToNumber = Integer.parseInt(number);
                if (stringToNumber < 0) {
                    throw new RuntimeException();
                }
                sum += stringToNumber;
            }
        }

        return sum;
    }
}
