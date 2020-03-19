package calculator;

import java.util.Stack;

public class Calculator2 {

    private static final String Separator = " ";

    private Stack<String> order = new Stack<>();

    public long calculate(String s) {
        addToStack(s.split(Separator));

        while (order.size() != 1) {
            long x = Long.parseLong(order.pop());
            CalculatorType calculatorType = CalculatorType.find(order.pop());
            long y = Long.parseLong(order.pop());
            long result = calculatorType.calculate(x, y);
            order.push(String.valueOf(result));
        }
        return Long.parseLong(order.pop());
    }

    private void addToStack(String[] split) {
        for (int i = split.length - 1; i >= 0; i--) {
            order.push(split[i]);
        }
    }


    public enum CalculatorType {
        ADD("+") {
            long calculate(long x, long y) {
                return x + y;
            }
        },
        MINUS("-") {
            long calculate(long x, long y) {
                return x - y;
            }
        },
        MULTIPLE("*") {
            long calculate(long x, long y) {
                return x * y;
            }
        },
        DIVIDE("/") {
            long calculate(long x, long y) {
                return x / y;
            }
        };

        String value;

        CalculatorType(String value) {
            this.value = value;
        }

        static CalculatorType find(String search) {
            for (CalculatorType calculatorType : values()) {
                if (calculatorType.value.equals(search)) {
                    return calculatorType;
                }
            }
            throw new IllegalArgumentException();
        }

        abstract long calculate(long x, long y);
    }


}