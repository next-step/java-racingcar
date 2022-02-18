package calculator;

import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static String[] inputExpressions() {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        return expression.split(" ");
    }
}
