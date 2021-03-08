package calculator;

/**
 * 피연산자
 */
public class Operand {

    public String[] stringToSplitStrArray(String input) throws Exception {
        stringNullCheck(input);

        String[] result = input.split(" ");

        splitSize3DownValid(result);
        splitSizeEvenValid(result);

        return result;
    }

    public int stringToInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    public void stringNullCheck(String input) throws IllegalArgumentException {
        if (input == null
                || input.trim().isEmpty()) {
            throw new IllegalArgumentException(CalculatorErrorMessage.NOT_A_NUMBER_ERROR);
        }
    }

    public void splitSizeEvenValid(String[] strArr) throws OperandSizeException {
        if (strArr.length % 2 == 0) {
            throw new OperandSizeException(CalculatorErrorMessage.SIZE_EVEN_ERROR);
        }
    }

    public void splitSize3DownValid(String[] strArr) throws OperandSizeException {
        if (strArr.length < 3) {
            throw new OperandSizeException(CalculatorErrorMessage.SIZE_THREE_DOWN_ERROR);
        }
    }
}
