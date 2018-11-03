package racing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RacingInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputTryNo(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

}
