package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    private static final String Separator = " ";

    private CalculationOrder calculationOrder = new CalculationOrder();

    public long calculate(String input) {
        verifyInput(input);
        calculationOrder.init(input.split(Separator));
        long x = stringToNumber(calculationOrder.next());
        return 0;
    }

    private long stringToNumber(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }

    public enum Operator {
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

        Operator(String value) {
            this.value = value;
        }

        static Operator findOperatorByValue(String operatorValue) {
            for (Operator operator : values()) {
                if (operator.value.equals(operatorValue)) {
                    return operator;
                }
            }
            throw new IllegalArgumentException();
        }

        abstract long calculate(long x, long y);
    }
}
