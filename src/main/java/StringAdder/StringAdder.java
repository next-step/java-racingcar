package StringAdder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    public static final int ZERO = 0;
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String BASIC_PATTERN = "[:,]";

    public int splitAndSum(String input) {
        if (isBlank(input)) {
            return ZERO;
        };

        return sumAll(toArrayList(splitString(input)));
    }

    public boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    public String[] splitString(String str) {
        Matcher m = CUSTOM_PATTERN.matcher(str);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        return str.split(BASIC_PATTERN);
    }

    public ArrayList<String> toArrayList(String[] strArray) {
        return new ArrayList<>(Arrays.asList(strArray));
    }

    public int sumAll(ArrayList<String> strArr) {
        return strArr.stream()
                    .mapToInt(Integer::parseInt)
                    .mapToObj(n -> new PositiveNumber(n))
                    .mapToInt(PositiveNumber::getNumber)
                    .sum();
    }
}
