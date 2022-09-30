package service;


import utils.StringUtils;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculatorService {

    private StringAddCalculatorService() {
        throw new IllegalStateException("Utility class");
    }


    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String string) {
        if (StringUtils.isEmpty(string)) {
            return 0;
        }

        List<String> splitStringList = splitString(string);

        List<Integer> positiveIntegerList = StringUtils.convertStringListToPositiveIntegerList(splitStringList);

        return positiveIntegerList.stream().reduce(0, Integer::sum);
    }

    private static List<String> splitString(String string) {
        List<String> delimiterList = getDelimiterList(string);
        String delimiterRegex = String.join("|", delimiterList);

        String targetString = getTargetString(string);

       return Arrays.asList(targetString.split(delimiterRegex));
    }

    private static List<String> getDelimiterList(String string) {
        if (string.matches(CUSTOM_DELIMITER_REGEX)) {
            String customDelimiter = string.substring(string.indexOf("//") + "//".length(), string.indexOf("\n"));
            return Arrays.asList(",", ":", customDelimiter);
        }

        return Arrays.asList(",", ":");
    }

    private static String getTargetString(String string) {
        return string.matches(CUSTOM_DELIMITER_REGEX) ? string.substring(string.indexOf("\n") + 1) : string;
    }
}
