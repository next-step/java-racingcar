package step04;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int readInteger(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }
}
