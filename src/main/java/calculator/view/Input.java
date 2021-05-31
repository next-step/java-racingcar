package calculator.view;

import java.util.Scanner;

public final class Input {
    private Input() {
    }

    public static String mathExpressionInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
