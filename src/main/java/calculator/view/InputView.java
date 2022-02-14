package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getLine() {
        String line = scanner.nextLine();
        validateEmptyLine(line);
        return line;
    }

    public static void validateEmptyLine(String line) {
        if (line.isEmpty() || line == null) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열 입니다.");
        }
    }
}
