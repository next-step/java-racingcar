package calculator.domain;

import calculator.view.UserInput;

public class Calculator {
    final private UserInput userInput;

    public Calculator(UserInput userInput) {
        this.userInput = userInput;
    }

    public void calculate() {
        Expression expression;
        do {
            String input = userInput.getInput();
            expression = new Expression(input);
        } while (checkDivideZero(expression));
    }

    private boolean checkDivideZero(Expression expression) {
        try {
            expression.calculate();
            expression.printResult();
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            return true;
        }
        return false;
    }
}
