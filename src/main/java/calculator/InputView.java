package calculator;

import java.util.Scanner;

public class InputView {

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        return string;
    }

    public static String[] parsing(String expression) {
        return expression.split(" ");
    }
}
