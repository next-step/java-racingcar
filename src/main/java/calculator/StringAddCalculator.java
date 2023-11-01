package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        List<Integer> operands = operands(text);
        return sum(operands);
    }

    private static List<Integer> operands(String text) {
        List<Integer> operand = new ArrayList();

        boolean isTextNullOrEmpty = text == null || text.isEmpty();
        if (isTextNullOrEmpty) {
            return operand;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            for (String token : tokens) {
                operand.add(integer(token));
            }
            return operand;
        }


        String[] tokens = text.split(",|:");
        for (String token : tokens) {
            operand.add(integer(token));
        }

        return operand;
    }

    private static int sum(List<Integer> operands) {
        int result = 0;
        for (int operand : operands) {
            result += operand;
        }
        return result;
    }

    private static int integer(String text) {
        int result = Integer.parseInt(text);
        if (result < 0) throw new RuntimeException("음수는 사용할 수 없습니다.");
        return result;
    }
}
