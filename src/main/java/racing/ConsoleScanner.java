package racing;

import java.util.Scanner;

import static racing.StringValidator.isBlank;

public class ConsoleScanner {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString() {
        String input = SCANNER.nextLine();
        if (isBlank(input)) throw new RuntimeException("공백을 입력했습니다.");
        return input;
    }


    public static Integer inputInt() {
        Integer number;
        try {
            number = SCANNER.nextInt();
        } catch (Exception ex) {
            throw new RuntimeException("숫자를 입력받지못했습니다.");
        }

        if (isPositive(number)) return number;
        throw new RuntimeException("음수를 입력했습니다.");
    }

    private static boolean isPositive(Integer num) {
        if (num == null) {
            return false;
        }
        return num > 0;
    }
}
