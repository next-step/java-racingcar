package calculator.ver2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAdditionCalculator {
    static PositiveNumber calculate(String text) {
        if (isBlank(text)) {
            return new PositiveNumber("0");
        }
        return add(convertToPositiveNumber(splitDelimiter(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static List<String> splitDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }
        return Arrays.asList(text.split("[,:]"));
    }

    private static List<PositiveNumber> convertToPositiveNumber(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }


    private static PositiveNumber add(List<PositiveNumber> operands) {
        PositiveNumber temp = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            temp.add(operands.get(i));
        }
        return temp;
    }
}
