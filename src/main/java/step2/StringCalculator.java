package step2;

public class StringCalculator {

    private String inputString;
    private int totalValue;

    public StringCalculator(String inputString) {
        this.inputString = inputString;
        this.totalValue = 0;
    }

    public int stringCalculate() {
        StringUtil stringUtil = new StringUtil(inputString);
        String[] numberAndOperatorArray = stringUtil.splitBySpace();

        totalValue = Integer.parseInt(numberAndOperatorArray[0]);
        for (int i = 1; i < numberAndOperatorArray.length; i ++) {
            if (isOperatorPosition(i)) {
                Calculator calculator = new Calculator(totalValue);
                totalValue = calculator.calculate(numberAndOperatorArray[i], Integer.parseInt(numberAndOperatorArray[i + 1]));
            }
        }

        return totalValue;
    }

    private boolean isOperatorPosition(int index) {
        return index%2 == 1;
    }
}
