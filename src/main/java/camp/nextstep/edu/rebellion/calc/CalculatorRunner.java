package camp.nextstep.edu.rebellion.calc;

public class CalculatorRunner {
    public static void main(String[] args) {
        String expression = CalculatorInput.getExpression();
        System.out.println("결과는 : " + Calculator.calc(expression) + " 입니다");
    }
}
