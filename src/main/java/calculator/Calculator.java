package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public void updateExpression(String expressionString) {
        List<String> elements = Arrays.asList(expressionString.split(" "));
        try {
            numbers.add(Integer.valueOf((elements.get(0))));

            for (int i = 1; i < elements.size(); i = i + 2) {
                operators.add(Operator.find(elements.get(i)));
                numbers.add(Integer.valueOf((elements.get(i + 1))));
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("계산할 수 없는 계산식 입니다.");
        }

        if (!validation()) {
            throw new IllegalArgumentException("계산할 수 없는 계산식 입니다.");
        }
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int operatorIndex = 0, numberIndex = 1;
            operatorIndex < operators.size();
            operatorIndex++, numberIndex++) {
            Operator operator = operators.get(operatorIndex);
            int number = numbers.get(numberIndex);
            result = operator.calculate(result, number);
        }

        return result;
    }

    private boolean validation() {
        if (numbers.size() < 1) {
            return false;
        }

        if (numbers.size() != operators.size() + 1) {
            return false;
        }

        return true;
    }
}
