package racing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestNumber(String text) {
        System.out.println(text);
        int num = scanner.nextInt();
        validateCarNumber(num);
        return num;
    }

    private static void validateCarNumber(int input) {
        if (input <= 0) {
            throw new RuntimeException("올바르지 않은 값입니다.");
        }
    }

}

