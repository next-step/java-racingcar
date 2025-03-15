package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInput(String text) {
        while (true) {
            System.out.println(text);

            try {
                int value = SCANNER.nextInt();
                if (value > 0) return value;
            } catch (InputMismatchException e) {
                // 잘못된 형식 패스
            }

            System.out.println("양의 정수만 허용됩니다.");
        }
    }

}
