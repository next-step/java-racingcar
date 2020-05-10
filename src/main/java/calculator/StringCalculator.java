package calculator;

public class StringCalculator {

    public double run(String input) {
        isBlank(input);
        String[] inputTokens = input.split(" ");

        double result = validateInputTokens(inputTokens);
        for (int i = 1; i < inputTokens.length; i += 2) {
            OperationSymbol operationSymbol = OperationSymbol.getOperationSymbol(inputTokens[i]);
            result = operationSymbol.calculate(result, convertStringToDouble(inputTokens[i + 1]));
        }
        return result;
    }

    private void isBlank(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("계산식을 입력해주세요.");
        }
    }

    private double convertStringToDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("연산하기 위해 숫자를 입력해주세요. " + value);
        }
    }

    private double validateInputTokens(String[] inputTokens) {
        if (inputTokens.length % 2 == 0) {
            throw new IllegalArgumentException("계산식이 올바르지 않습니다.");
        }

        return validateFirstTokenIsNumber(inputTokens[0]);
    }

    private double validateFirstTokenIsNumber(String firstToken) {
        return convertStringToDouble(firstToken);
    }
}
