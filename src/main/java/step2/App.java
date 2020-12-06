package step2;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MathematicalExpression expression = getExpression();
        Calculator calculator = new Calculator(expression);
        System.out.println("계산 결과는 : " + calculator.calculate().toString() + "입니다.");
    }

    private static MathematicalExpression getExpression() {
        System.out.println("식을 입력해 주세요");
        String text = scanner.nextLine();
        try {
            return MathematicalExpression.of(text);
        } catch (IllegalArgumentException e) {
            return getExpression();
        }
    }

}
