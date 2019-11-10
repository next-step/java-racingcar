package calculator;

public class StringCalculator {

    private static final String EMPTY_SPACE_CHARACTER = " ";

    private String valueToCalculate;
    private InputValidator inputValidator;

    public StringCalculator(String valueToCalculate) {
        inputValidator = new InputValidator();
        this.valueToCalculate = inputValidator.validateValueToCalulate(valueToCalculate);
    }

    public int execute() {
        String[] inputValues = valueToCalculate.split(EMPTY_SPACE_CHARACTER);
        int leftValue = Integer.parseInt(inputValues[0]);
        int maxI = inputValues.length;

        for (int i = 1; i < maxI; i += 2) {
            leftValue = calculate(inputValues, leftValue, i);
        }
        return leftValue;
    }

    public int calculate(String[] inputValues, int leftValue, int index) {
        if(isPossibleCalculate(inputValues.length, index)) {
            int rightValue = Integer.parseInt(inputValues[index + 1]);
            String operationSymbol = inputValues[index];

            leftValue = Calculator.execute(operationSymbol, leftValue, rightValue);
            return leftValue;
        }
        return leftValue;
    }

    private boolean isPossibleCalculate(int maxIndex, int index) {
        return (maxIndex > index + 1) ? true : false;
    }

}
