package calculator;

public class CalculatorMain {



    public static void main(String[] args) {

        String formula            = "1 - 2 * 4 / 3";
        String[] result           = formula.split(" ");
        String[] operationSymbols = {"+","-","*","/"};
        double resultVal          = 0;

        Calculator calc = new Calculator(formula,operationSymbols);
        resultVal = calc.calculate(result);
        System.out.println("결과값은 " + resultVal + "  입니다.");
    }

}
