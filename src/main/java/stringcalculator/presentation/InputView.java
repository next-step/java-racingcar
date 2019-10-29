package stringcalculator.presentation;

import java.util.Scanner;

public class InputView {

    private String expression;

    public InputView() {
        Scanner scanner = new Scanner(System.in);
        this.expression = scanner.nextLine();
    }

    public String getExpression() {
        return this.expression;
    }

}
