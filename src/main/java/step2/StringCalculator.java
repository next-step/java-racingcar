package step2;

public class StringCalculator {
    private String[] inputArray;
    private double result;

    public StringCalculator(String input, String splitKeyword) {
        initialize(input, splitKeyword);
    }

    public StringCalculator(String input) {
        initialize(input, " ");
    }

    public double getResult() {
        return result;
    }

    private void initialize(String input, String key) {
        this.inputArray = StringUtil.doSplit(input, key);
    }

    public void run() {
        checkLenghthIsOdd();
        Operator op = Operator.ADD;
        for (int i = 0; i < inputArray.length; i++) {
            if (op != null && StringUtil.isNumber(inputArray[i])) {
                result = op.calculate(result, StringUtil.convertStringToDouble(inputArray[i]));
                op = null;
                continue;
            }
            op = matchOperator(i);
        }
    }

    private void checkLenghthIsOdd() {
        if (inputArray.length == 1 || inputArray.length % 2 == 0)
            throw new IllegalStateException("You need to enter a string to complete the calculation.");
    }

    private Operator matchOperator(int index) {
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
        return op;
    }
}
