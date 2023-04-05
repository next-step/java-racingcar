package edu.nextstep.camp.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String nums) {
        if (!validateEmptyNums(nums)) {
            return 0;
        }

        String[] numsArr = splitNums(nums);

        return sumNums(numsArr);
    }

    private static int sumNums(String[] numsArr) {
        return Arrays.stream(numsArr)
                .mapToInt(StringAddCalculator::parseIntNumStr)
                .sum();
    }

    private static int parseIntNumStr(String numStr) {
        int num = Integer.parseInt(numStr);

        if (num < 0) {
            throw new RuntimeException("Number is negative");
        }

        return num;
    }

    private static String[] splitNums(String nums) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(nums);

        if (m.find()) {
            String customDelimiter = m.group(1);

            return m.group(2)
                    .split(customDelimiter);
        }

        return nums.split(",|:");
    }

    private static boolean validateEmptyNums(String nums) {
        return nums != null && !nums.isEmpty();
    }
}
