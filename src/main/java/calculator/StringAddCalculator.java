package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAddCalculator {

    public static int add(String input) {
        if(isEmpty(input) ) {
            return 0;
        }

        return getSum(parseIntArray(splitInput(input)));
    }

    public static boolean isEmpty(String input) {
        return input == null || input.length() == 0;
    }

    public static String[] splitInput(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String delimeter = m.group(1);
            return m.group(2).split(delimeter);
        }

        return input.split("[,:]");
    }

    public static List<PositiveInteger> parseIntArray(String[] strArray) {
        return Stream.of(strArray)
                    .map(Integer::parseInt)
                    .map(PositiveInteger::new)
                    .collect(Collectors.toList());
    }

    public static int getSum(List<PositiveInteger> positiveIntegers) {
        return positiveIntegers.stream()
                        .mapToInt(PositiveInteger::getNumber)
                        .sum();
    }
}