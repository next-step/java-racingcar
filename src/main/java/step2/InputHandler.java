package step2;

import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static MathematicalExpression getMathematicalExpression() {
        System.out.println("식을 입력해 주세요");
        String text = scanner.nextLine();
        try {
            return MathematicalExpression.of(text);
        } catch (IllegalArgumentException e) {
            return getMathematicalExpression();
        }
    }


}
