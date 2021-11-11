package step4;

import java.util.Scanner;

public class GameInput {

    static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        return scanner.nextInt();
    }

    public static String[] readCarNames() {
        return scanner.nextLine().split(",");
    }
}
