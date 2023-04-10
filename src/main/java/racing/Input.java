package racing;

import java.util.Scanner;

public class Input {
    public static Integer inputInt() {
        Integer number;
        try {
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();
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
