package racing.view;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String makeCarNames() {
        return scanner.nextLine();
    }

    public static int makeGameRepeatCount() {
        return scanner.nextInt();
    }
}
