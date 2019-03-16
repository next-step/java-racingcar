package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAddCalculator {

    public static int add(String input) {
        if(isNullOrEmptyString(input) ) {
            return 0;
        }

        return getSum(parseIntArray(splitInput(input)));
    }

    static boolean isNullOrEmptyString(String input) {
        return input == null || input.length() == 0;
    }


    static String[] splitInput(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String delimeter = m.group(1);
            return m.group(2).split(delimeter);
        }

        return input.split("[,:]");
    }

    static List<PositiveInteger> parseIntArray(String[] strArray) {
        return Stream.of(strArray)
                    .map(Integer::parseInt)
                    .map(PositiveInteger::new)
                    .collect(Collectors.toList());
    }

    static int getSum(List<PositiveInteger> positiveIntegers) {
        return positiveIntegers.stream()
                        .mapToInt(PositiveInteger::getNumber)
                        .sum();
    }
}