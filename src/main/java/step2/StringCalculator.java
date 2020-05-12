package step2;

public class StringCalculator {

    interface Calculator {
        int calculate(int result, int nextNumber);
    }

    enum Operator {

        PLUS("+", (result, nextNumber) -> result + nextNumber),
        MINUS("-", (result, nextNumber) -> result - nextNumber),
        MULTIPLY("*", (result, nextNumber) -> result * nextNumber),
        DIVIDE("/", (result, nextNumber) -> result / nextNumber);

        private String operator;
        private Calculator calculator;

        Operator(String operator, Calculator calculator) {
            this.operator = operator;
            this.calculator = calculator;
        }

        public static int calculate(int result, int nextNumber, String operator) {
            for (Operator op : Operator.values()) {
                if (op.operator.equals(operator)) {
                    return op.calculator.calculate(result, nextNumber);
                }
            }
            throw new IllegalArgumentException();
        }

    }

    public static final String SEPARATOR = " ";
    private static String input;
    private static String[] inputArray;

    private StringCalculator() {
    }

    public StringCalculator(String input) {

        if (null == input) {
            throw new IllegalArgumentException("Null Or Empty.");
        }

        this.input = input;
        this.inputArray = input.split(SEPARATOR);
    }

    public void inputCheck() {
        InputCheck.checkEmpty(input, SEPARATOR);
        InputCheck.checkMinimumExpression(inputArray);
        InputCheck.checkMatchingNumbersAndOperators(inputArray);
        InputCheck.checkNumberString(inputArray);
        InputCheck.checkCalculateSymbol(inputArray);
    }

    public int calculate() {
        int result = Integer.parseInt(inputArray[0]);

        // calculate
        for (int i = 0; i < inputArray.length - 1; i += 2) {
            result = Operator.calculate(result, Integer.parseInt(inputArray[i + 2]), inputArray[i + 1]);
        }

        return result;
    }

    public static String getSEPARATOR() {
        return SEPARATOR;
    }

    public static String getInput() {
        return input;
    }

    public static String[] getInputArray() {
        return inputArray;
    }
}
