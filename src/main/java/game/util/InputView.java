package game.util;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String insertValue() {
        return scanner.nextLine();
    }
}
