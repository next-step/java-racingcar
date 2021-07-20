package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Calculator {

    private final List<Integer> numberQueue = new ArrayList<>();
    private final List<IntBinaryOperator> operatorQueue = new ArrayList<>();

    public void updateExpression(String expressionString) {
        List<String> elements = Arrays.asList(expressionString.split(" "));
        try {
            numberQueue.add(Integer.valueOf((elements.get(0))));

            for (int i = 1; i < elements.size(); i = i + 2) {
                operatorQueue.add(Operator.find(elements.get(i)));
                numberQueue.add(Integer.valueOf((elements.get(i + 1))));
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("계산할 수 없는 계산식 입니다.");
        }

        if (!validation()) {
            throw new IllegalArgumentException("계산할 수 없는 계산식 입니다.");
        }
    }

    public int calculate() {
        int result = numberQueue.get(0);
        for (int operatorIndex = 0, numberIndex = 1; operatorIndex < operatorQueue.size(); operatorIndex++, numberIndex++) {
            IntBinaryOperator operator = operatorQueue.get(operatorIndex);
            int number = numberQueue.get(numberIndex);
            result = operator.applyAsInt(result, number);
        }

        return result;
    }

    private boolean validation() {
        if (numberQueue.size() < 1) {
            return false;
        }

        if (numberQueue.size() != operatorQueue.size() + 1) {
            return false;
        }

        return true;
    }
}
