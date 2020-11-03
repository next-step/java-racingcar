package string.calculator;

public enum Operator implements CalculatorBinaryOperator {

    ADD((firstNum, secondNum) -> String.valueOf(Integer.parseInt(firstNum) + Integer.parseInt(secondNum))),
    SUBTRACT((firstNum, secondNum) -> String.valueOf(Integer.parseInt(firstNum) - Integer.parseInt(secondNum))),
    MULTIPLE((firstNum, secondNum) -> String.valueOf(Integer.parseInt(firstNum) * Integer.parseInt(secondNum))),
    DIVISION((firstNum, secondNum) -> String.valueOf(Integer.parseInt(firstNum) / Integer.parseInt(secondNum)));

    private final CalculatorBinaryOperator binaryOperator;

    Operator(CalculatorBinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    @Override
    public String calculate(String first, String second) {
        return binaryOperator.calculate(first, second);
    }

    public static Operator getOperator(String operator) {
        switch (operator) {
            case "+":
                return ADD;
            case "-":
                return SUBTRACT;
            case "*":
                return MULTIPLE;
            case "/":
                return DIVISION;
            default:
                throw new IllegalArgumentException("올바른 사칙연산을 입력해야 합니다.");
        }
    }
}