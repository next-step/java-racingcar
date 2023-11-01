package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final String defaultDelimiterText = ",|:";
    private final String defaultRegex = "//(.)\n(.*)";

    public int splitAndSum(String text) {
        Operand operand = operand(text);
        return sum(operand);
    }

    private Operand operand(String text) {
        Operand operand = new Operand(new ArrayList<>());
        boolean isTextNullOrEmpty = text == null || text.isEmpty();
        if (isTextNullOrEmpty) {
            return operand;
        }
        Delimiter delimiter = new Delimiter(defaultDelimiterText);
        Matcher m = Pattern.compile(defaultRegex).matcher(text);
        if (m.find()) {
            delimiter = new Delimiter(m.group(1));
            text = m.group(2);
        }
        String[] tokens = text.split(delimiter.delimiter());
        for (String token : tokens) {
            operand.add(parsedInt(token));
        }
        return operand;
    }

    private int sum(Operand operand) {
        int result = 0;
        for (int i = 0; i < operand.length(); i++) {
            result += operand.operand(i);
        }
        return result;
    }

    private int parsedInt(String text) {
        int result = Integer.parseInt(text);
        if (result < 0) throw new RuntimeException("음수는 사용할 수 없습니다.");
        return result;
    }
}
