package calculator;

import java.util.Scanner;

public class InputView {

    public static String[] inputExpressions() {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        return expression.split(" ");
    }
}
