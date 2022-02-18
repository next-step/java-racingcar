package calculator;

public class CalculatorExcuter {

    private CalculatorExcuter() {
    }

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String[] expressions = InputView.inputExpressions();
        int result = Calculator.calculate(expressions);
        System.out.println(result);
    }
}
