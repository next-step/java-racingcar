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
        if (inputSize < Constant.MIN_INPUT_SIZE) {
            PrintUtils.printErrorInputSize();
            throw new IllegalArgumentException(Constant.ERROR_INPUT_SIZE);
        }
        return true;
    }

    private static boolean validateAppropriateOperator(String[] inputArray) throws IllegalArgumentException {
        for (int i = Constant.OPERATOR_START_INDEX; i < inputArray.length; i += 2) {
                Operator.validateOperator(inputArray[i]);
        }
        return true;
    }

    private static boolean validateOperand(String[] inputArray) throws IllegalArgumentException {
        for (int i = Constant.OPERAND_START_INDEX; i < inputArray.length; i += 2) {
            if (!NumberUtils.isInteger(inputArray[i])) {
                PrintUtils.printErrorOperand();
                throw new IllegalArgumentException(Constant.ERROR_OPERAND);
            }
        }
        return true;
    }
}
