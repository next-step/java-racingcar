package game.view;

import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static int insertInt() {
        return scanner.nextInt();
    }
}
