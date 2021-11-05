package calculator;

public class Calculator {

    public int calculate(String formula) {

        validate(formula);

        String[] array = formula.split(" ");
        int result = 0;

        for (int i = 0; i < array.length - 1; i += 2) {
            int first = isFirst(i) ? Integer.parseInt(formula.split(" ")[i]) : result;
            String operator = formula.split(" ")[i+1];
            int second = Integer.parseInt(formula.split(" ")[i+2]);

            result = calculate(first, operator, second);
        }

        return result;
    }

    private boolean isFirst(int i) {
        return i == 0;
    }

    private void validate(String formula) {
        if (formula == null || formula.isEmpty() || " ".equals(formula)) {
            throw new IllegalArgumentException("올바른 수식을 입력해주세요.");
        }
    }

    public int calculate(int first, String operation, int second) {
        if ("/".equals(operation) && second == 0) {
            throw new IllegalArgumentException("0으로는 숫자를 나눌 수 없습니다.");
        }

        return Operator.getOperator(operation).calculate(first, second);
    }


}
