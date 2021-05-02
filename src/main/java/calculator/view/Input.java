package calculator.view;

import java.util.Scanner;

public class Input {
    public String inputMathExpression() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
