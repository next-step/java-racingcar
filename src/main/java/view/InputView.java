package view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntValue(String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }
}