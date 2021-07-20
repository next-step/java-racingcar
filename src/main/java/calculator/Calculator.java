package calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class Calculator {

    private final Queue<Integer> numberQueue = new ArrayDeque<>();
    private final Queue<Function<int[], Integer>> operatorQueue = new ArrayDeque<>();

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
        int result = numberQueue.poll();

        while (!operatorQueue.isEmpty()) {
            Function<int[], Integer> operator = operatorQueue.poll();
            int[] numbers = new int[]{result, numberQueue.poll()};

            result = operator.apply(numbers);
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
