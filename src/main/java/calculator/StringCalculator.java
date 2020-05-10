package calculator;

public class StringCalculator {

    public double run(String input) {
        isBlank(input);
        String[] splits = input.split(" ");

        double result = convertStringToDouble(splits[0]);
        for (int i = 1; i < splits.length; i += 2) {
            OperationSymbol operationSymbol = OperationSymbol.getOperationSymbol(splits[i]);
            result = operationSymbol.calculate(result, convertStringToDouble(splits[i + 1]));
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
}