package stringCalculator;

public class StringCalculator {
    final static String DELIMITER = " ";

    public int calculate(String input) {
        String[] splitedInput = getValidatedAndSplitedParam(input);
        int result = Integer.parseInt(splitedInput[0]);
        for (int i = 1; i < splitedInput.length; i += 2) {
            result = Operation.getOperation(splitedInput[i]).operate(result, Integer.parseInt(splitedInput[i + 1]));
        }
        return result;
    }

    private String[] getValidatedAndSplitedParam(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("input is null or empty");
        }
        String[] validateResult = input.split(DELIMITER);
        if (validateResult.length % 2 == 0) {
            throw new IllegalArgumentException("calculating param counts is not odd number");
        }
        for (int i = 0; i < validateResult.length; i++) {
            if (i % 2 == 0) {
                try {
                    Integer.parseInt(validateResult[i]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("calculating param is wrong : contained not number or wrong opterator");
                }
            } else if ("/".equals(validateResult[i]) && Integer.parseInt(validateResult[i + 1]) == 0) {
                throw new IllegalArgumentException("calculating param is wrong : can't divide by 0");
            }
        }
        return validateResult;
    }
}
