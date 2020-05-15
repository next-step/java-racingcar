package step2;

public class StringCalculator {
    private String[] inputArray;
    private double result;

    public StringCalculator(String input, String splitKeyword) {
        this.inputArray = StringUtil.doSplit(input, splitKeyword);
    }

    public StringCalculator(String input) {
        this(input," ");
    }

    public double getResult() {
        return result;
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
            op = Operator.matchOperator(inputArray[i]);
        }
    }

    private void checkLenghthIsOdd() {
        if (inputArray.length == 1 || inputArray.length % 2 == 0)
            throw new IllegalStateException("You need to enter a string to complete the calculation.");
    }
}
