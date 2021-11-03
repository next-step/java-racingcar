package edu.nextstep.camp;

import java.util.Arrays;
import java.util.Iterator;

public class Calculator {
    public int add(int first, int second) {
        return first + second;
    }

    public int subtract(int first, int second) {
        return first - second;
    }

    public int product(int first, int second) {
        return first * second;
    }

    public int divide(int first, int second) {
        return first / second;
    }

    public int calculate(String command) {
        if (command == null || command.isEmpty())
            throw new IllegalArgumentException("command must not be empty: " + command);

        String[] op = command.split(" ");

        if (op.length < 3)
            throw new IllegalArgumentException("invalid input: " + command);

        Iterator<String> iter = Arrays.stream(op)
                .filter(s -> s != null && !s.isEmpty())
                .iterator();

        Step step = Step.FIRST;
        int number = 0;
        String operand = "";
        while (iter.hasNext()) {
            switch (step) {
                case FIRST:
                    number = Integer.parseInt(iter.next());
                    step = Step.OPERAND;
                    break;
                case OPERAND:
                    operand = iter.next();
                    step = Step.SECOND;
                    break;
                case SECOND:
                    number = calculate(number, operand, Integer.parseInt(iter.next()));
                    step = Step.OPERAND; // 가장 첫항을 제외하고는 좌항은 계산의 좌과이므로 연산자를 추출할 차래다.
                    break;
            }
        }

        if (step != Step.OPERAND) // 우항 처리가 안됐다는 의미. 입력이 뭔가 잘못됐겠지..
            throw new IllegalArgumentException("invalid input: " + command);

        return number;
    }

    private enum Step {
        FIRST,
        OPERAND,
        SECOND,
    }

    public int calculate(int first, String operand, int second) {
        switch (operand) {
            case "+":
                return add(first, second);
            case "-":
                return subtract(first, second);
            case "*":
                return product(first, second);
            case "/":
                return divide(first, second);
            default:
                throw new IllegalArgumentException("invalid operand: " + operand);
        }
    }
}
