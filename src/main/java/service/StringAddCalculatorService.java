package service;


import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAddCalculatorService {

    private StringAddCalculatorService() {
        throw new IllegalStateException("Utility class");
    }

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String CUSTOM_DELIMITER_REGEX_START_STRING = "//";
    private static final String CUSTOM_DELIMITER_REGEX_END_STRING = "\n";

    private static final String[] defaultDelimiterArray = {",", ":"};

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
        List<String> delimiterList = new ArrayList<>(Arrays.asList(defaultDelimiterArray));
        if (string.matches(CUSTOM_DELIMITER_REGEX)) {
            String customDelimiter = string.substring(
                    string.indexOf(CUSTOM_DELIMITER_REGEX_START_STRING) + CUSTOM_DELIMITER_REGEX_START_STRING.length(),
                    string.indexOf(CUSTOM_DELIMITER_REGEX_END_STRING));

            delimiterList.add(customDelimiter);
        }
        return delimiterList;
    }

    private static String getTargetString(String string) {
        return string.matches(CUSTOM_DELIMITER_REGEX) ? string.substring(string.indexOf("\n") + 1) : string;
    }
}
