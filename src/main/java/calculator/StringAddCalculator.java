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

        String delimiter = ",|:";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }


        String[] tokens = text.split(delimiter);
        for (String token : tokens) {
            operand.add(parsedInt(token));
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

    private static int parsedInt(String text) {
        int result = Integer.parseInt(text);
        if (result < 0) throw new RuntimeException("음수는 사용할 수 없습니다.");
        return result;
    }
}
