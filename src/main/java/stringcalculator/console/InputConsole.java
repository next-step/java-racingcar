package stringcalculator.console;

import java.util.Scanner;

/**
 * 수식을 입력받기 위한 콘솔
 */
public class InputConsole {
    private static final String INPUT_MESSAGE = "수식을 입력해주세요:";

    private InputConsole() {
    }

    public static InputExpression readExpression() {
        System.out.println(INPUT_MESSAGE);
        return new InputExpression(readString());
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
