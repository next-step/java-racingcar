package step2;

public class StringCalculator {

    private static final String BLANK = " ";

    public int calculate(String input) {
        checkNullOrEmpty(input);
        String[] inputSplit = input.split(BLANK);
        int result = stringToNumber(inputSplit[0]);
        for(int i = 1; i < inputSplit.length; i += 2) {
            result = Operator.operate(inputSplit[i], result, stringToNumber(inputSplit[i + 1]));
        }

        return result;
    }

    private int stringToNumber(String letter) {
        try {
            return Integer.parseInt(letter);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.INPUT_NUMERIC);
        }
    }

    private void checkNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(Constants.INPUT_NULL_OR_EMPTY);
        }
    }

}
