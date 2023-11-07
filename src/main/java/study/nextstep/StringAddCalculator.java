package study.nextstep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String suffix = "\n";

    public static int splitAndSum(String example) {
        if(example == null || example.isEmpty()) {
            return 0;
        }

        return numberList(example)
                .stream()
                .map(num -> {
                    checkPositiveNumber(num);
                    return Integer.parseInt(num);
                }).reduce(0, Integer::sum);
    }

    private static List<String> numberList(String example) {
        Map<String, String> result = separatorAndTrimText(example);
        return Arrays.asList(result.get("text")
                .split(result.get("separator")));
    }

    private static Map<String, String> separatorAndTrimText(String example) {
        Map<String, String> result = new HashMap<>();
        StringBuilder separators = new StringBuilder("[,|:");
        String separator = customSeperator(example);

        if(!separator.isEmpty()) {
            separators.append("|").append(separator);
            example = example.substring(example.indexOf(suffix)).trim();
        }

        separators.append("]");
        result.put("separator", separators.toString());
        result.put("text", example);
        return result;
    }

    private static String customSeperator(String example) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(example);
        return m.find() ? m.group(1) : "";
    }

    private static void checkPositiveNumber(String number) {
        if(!Character.isDigit(number.charAt(0))) {
            throw new RuntimeException();
        }

        if(Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}
