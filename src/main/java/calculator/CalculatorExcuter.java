package calculator;

public class CalculatorExcuter {

    public static void execute() {
        System.out.println("수식을 입력하시오: ");
        String[] expressions = InputView.inputExpressions();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(expressions);
        System.out.println(result);
    }
}
