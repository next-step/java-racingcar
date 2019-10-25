package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static void main(String[] args) {
        new Calculator().run();
    }

    private void run() {
        String inputString = "2 + 3 * 4 / 2";

        long result = calculate(inputString);
        System.out.println(result);
    }

    public long calculate(String inputString) {

        if (inputString == null) {
            throw new IllegalArgumentException("입력이 올바르지 않습니다.");
        }
        String[] split = inputString.split(" ");

        List<String> list = Arrays.stream(split)
                .filter(a -> !"".equals(a))
                .collect(Collectors.toList());

        if (list.size() < 2 || list.size() % 2 == 0) {
            throw new IllegalArgumentException("숫자와 연산자의 개수가 맞지 않습니다.");
        }

        long result = 0;
        OperatorType operatorType = null;

        for (String s : list) {

            if (isNumeric(s)) {
                long number = Long.parseLong(s);
                result = operatorType == null ? number : operatorType.getExpression().apply(result, number);
                continue;
            }

            operatorType = OperatorType.findByCode(s);
        }

        return result;
    }

    private boolean isNumeric(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String s) {
        return OperatorType.getOperatorCodes().contains(s);
    }

}
