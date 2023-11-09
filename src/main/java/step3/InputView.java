package step3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readIntInput(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public static String readStringInput(String msg) {
        System.out.println(msg);
        return scanner.next();
    }
}
