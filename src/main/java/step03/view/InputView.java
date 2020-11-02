package step03.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInteger(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
