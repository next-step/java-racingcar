package step2;

public class Main {

    public static void main(String[] args) {
        String expression = View.readExpression();

        View.printResult(Calculator.calculate(expression));
    }
}
