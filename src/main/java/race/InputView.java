package race;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getNumberInput(String msg, int min, int max) {
        int number;
        do {
            number = getNumber(msg);
        } while (!isValid(number, min, max));
        return number;
    }

    private static int getNumber(String message) {
        System.out.print(message);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        scanner.next();
        return -1;
    }

    private static boolean isValid(int number, int min, int max) {
        if (number >= min && number <= max) {
            return true;
        }
        System.out.println("1에서 10까지의 숫자만 입력 가능합니다.");
        return false;
    }
}
