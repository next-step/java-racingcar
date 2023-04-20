package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberCalculator {
    public static final String DEFAULT_DELIMETER_REGEX = ",|:";

    public static int splitAndSum(String sample) {

        if (sample.isBlank()) { // 이 자체로도 해석이 가능하다고 생각, 메서드로 만들면 어떤 장점이 있을지 고민.
            return 0;
        }

        String splitRegex;

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(sample); // TODO:: 상수로 만들기

        if (matcher.find()) {
            splitRegex = matcher.group(1); // TODO:: return 해야할 것이 splitRegex, sample 2개인데, 어떻게 메서드로 만들지?
            sample = matcher.group(2);
        } else {
            splitRegex = DEFAULT_DELIMETER_REGEX;
        }

        try {
            String[] data = sample.split(splitRegex);
            return Arrays.stream(data).mapToInt(stringNumber -> {
                int integerNumber = Integer.parseInt(stringNumber);
                if (integerNumber < 0) { // 음수
                    throw new RuntimeException("음수");
                }
                return integerNumber;

            }).sum();
        } catch (NumberFormatException numberFormatException) { //숫자가 아닌 문자
            throw new RuntimeException("음수");
        }
    }

}
