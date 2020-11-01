package study.step2;

public class StringCalculator {

    public long calculateStringInput(String inputString) {
        validateInput(inputString);
        String[] splitStrings = inputString.split(" ");
        long calculatedNumber = 0;
        long operandNumber = 0;

        StringOperator operator = StringOperator.symbol("+");
        for (String value : splitStrings) {
            switch (value) {
                case "+":
                case "-":
                case "*":
                case "/":
                    operator = StringOperator.symbol(value);
                    break;
                default:
                    operandNumber = Long.parseLong(value);
                    calculatedNumber = operator.calculate(calculatedNumber, operandNumber);
            }
        }
        return calculatedNumber;
    }

    private void validateInput(String inputString) throws IllegalArgumentException {

        if (inputString.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

    }
}
