package step2;

public class StringCalculator {
    private String[] inputArray;
    private double result;

    public StringCalculator(String input, String splitKeyword) {
        this.inputArray = StringUtil.doSplit(input, splitKeyword);
        run();
    }

    public StringCalculator(String input) {
        // 사용자가 따로 split 할 word를 정하지 않는다면 공백으로 처리함.
        this.inputArray = StringUtil.doSplit(input, " ");
        run();
    }

    public Double getResult() {
        return result;
    }

    private void run() {
        result = stringToDouble(0);
        for (int i = 1; i < inputArray.length; i += 2) {
            if (!StringUtil.isNumber(inputArray[i])) {
                matchOperator(i);
            }
        }
    }

    private void matchOperator(int index) {
        Operator op;
        switch (inputArray[index]) {
            case "+":
                op = Operator.ADD;
                break;
            case "-":
                op = Operator.MINUS;
                break;
            case "*":
                op = Operator.MULTIPLY;
                break;
            case "/":
                op = Operator.DEVIDE;
                break;
            default:
                throw new IllegalArgumentException("This is Disabled character.");
        }
        result = op.calculate(result, stringToDouble(index + 1));
    }

    private Double stringToDouble(int index) {
        try {
            return Double.parseDouble(inputArray[index]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't convert Double! index: " + index + " value: " + inputArray[index]);
        }
    }

    private enum Operator {
        ADD("+") {
            @Override
            public double calculate(double num1, double num2) {
                return num1 + num2;
            }
        },
        MINUS("-") {
            @Override
            public double calculate(double num1, double num2) {
                return num1 - num2;
            }
        },
        MULTIPLY("*") {
            @Override
            public double calculate(double num1, double num2) {
                return num1 * num2;
            }
        },
        DEVIDE("/") {
            @Override
            public double calculate(double num1, double num2) {
                return num1 / num2;
            }
        };
        private String operator;

        Operator(String str) {
            this.operator = str;
        }

        public abstract double calculate(double num1, double num2);
    }
}
