package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {
    private static final String BLANK = " ";
    private static final String NUMBER_OPERATOR = ".*[0-9+*/-].*";

    public int calculate(String input) {
        List<String> inputSplit = Arrays.asList(input.split(BLANK));
        int result = Integer.parseInt(inputSplit.get(0));
        for (int i = 0; i < inputSplit.size(); i++) {
            if (inputSplit.get(i).equals("+")) {
                result = Operator.PLUS.calculate(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
            if (inputSplit.get(i).equals("-")) {
                result = Operator.MINUS.calculate(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
            if (inputSplit.get(i).equals("*")) {
                result = Operator.TIMES.calculate(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
            if (inputSplit.get(i).equals("/")) {
                result = Operator.DIVISION.calculate(result, Integer.parseInt(inputSplit.get(i + 1)));
                continue;
            }
        }
        return result;
    }

    public void handleNullException(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    public void handleOperatorException(String input) {
        if (!input.contains(Operator.PLUS.getSymbol()) &&
                !input.contains(Operator.MINUS.getSymbol()) &&
                !input.contains(Operator.TIMES.getSymbol()) &&
                !input.contains(Operator.DIVISION.getSymbol())) {
            throw new IllegalArgumentException("입력값에 사칙연산이 없습니다.");
        }
    }

    public void handleNumberOperatorException(String input) {
        if (!Pattern.matches(NUMBER_OPERATOR, input)) {
            throw new IllegalArgumentException("입력값에 숫자나 사칙연산이 없습니다.");
        }
    }
}
