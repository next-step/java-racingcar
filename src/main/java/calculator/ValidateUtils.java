package calculator;

public class ValidateUtils {

    public static boolean validateInput(String[] input) {
        try {
            return validateInputSize(input.length)
                && validateAppropriateOperator(input)
                && validateOperand(input);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean validateInputSize(int inputSize) throws IllegalArgumentException {
        if (inputSize < 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private static boolean validateAppropriateOperator(String[] inputArray) throws IllegalArgumentException {
        for (int i = 1; i < inputArray.length; i += 2) {
                Operator.validateOperator(inputArray[i]);
        }
        return true;
    }

    private static boolean validateOperand(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i += 2) {
            if (!NumberUtils.isInteger(inputArray[i])) {
                return false;
            }
        }
        return true;
    }

}
