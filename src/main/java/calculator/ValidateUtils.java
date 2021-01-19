package calculator;

public class ValidateUtils {

    public static boolean validateInput(String[] input) {
        return validateInputSize(input.length)
            && validateAppropriateOperator(input)
            && validateOperand(input);
    }

    private static boolean validateInputSize(int inputSize) {
        if (inputSize < 3) {
            return false;
        }
        return true;
    }

    private static boolean validateAppropriateOperator(String[] inputArray) {
        for (int i = 1; i < inputArray.length; i += 2) {
            try {
                Operator.valueOf(inputArray[i]);
            } catch (java.lang.IllegalArgumentException e) {
                return false;
            }
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
