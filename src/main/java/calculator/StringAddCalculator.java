package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        Operands operands = operands(text);
        return sum(operands);
    }

    private static Operands operands(String text) {
        Operands operands = new Operands(new ArrayList<>());

        boolean isTextNullOrEmpty = text == null || text.isEmpty();
        if (isTextNullOrEmpty) {
            return operands;
        }

        String delimiter = ",|:";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }


        String[] tokens = text.split(delimiter);
        for (String token : tokens) {
            operands.add(parsedInt(token));
        }

        return operands;
    }

    private static int sum(Operands operands) {
        int result = 0;
        for(int i = 0; i < operands.length(); i++) {
            result += operands.operand(i);
        }
        return result;
    }

    private static int parsedInt(String text) {
        int result = Integer.parseInt(text);
        if (result < 0) throw new RuntimeException("음수는 사용할 수 없습니다.");
        return result;
    }
}
