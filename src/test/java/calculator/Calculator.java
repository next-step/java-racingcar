package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    private static final String Separator = " ";

    private CalculationOrder calculationOrder = new CalculationOrder();

    public long calculate(String input) {
        verifyInput(input);
        calculationOrder.init(input.split(Separator));
        return calculate();
    }

    private long calculate() {
        while (!calculationOrder.isComplete()) {
            long x = stringToNumber(calculationOrder.next());
            Operator operator = Operator.findOperatorByValue(calculationOrder.next());
            long y = stringToNumber(calculationOrder.next());
            calculationOrder.addCalculateResult(operator.calculate(x, y));
        }
        return calculationOrder.getCalculateTotalResult();
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
