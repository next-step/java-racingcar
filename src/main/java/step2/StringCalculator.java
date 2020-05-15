package step2;

public class StringCalculator {

    public static final String SEPARATOR = " ";

    private String input;
    private String[] inputArray;

    private StringCalculator() {
        // block
    }

    public StringCalculator(String input) {

        if (null == input) {
            throw new IllegalArgumentException("Null Or Empty.");
        }

        this.input = input;
        this.inputArray = input.split(SEPARATOR);

        InputCheck.inputCheck(input, inputArray);

    }

    public int calculate() {

        int result = Integer.parseInt(inputArray[0]);

        // calculate
        for (int i = 0; i < inputArray.length - 1; i += 2) {
            result = Operator.calculate(result, Integer.parseInt(inputArray[i + 2]), inputArray[i + 1]);
        }

        return result;

    }
}
