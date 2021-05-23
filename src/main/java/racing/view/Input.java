package racing.view;

import java.util.Scanner;

import static racing.view.Output.*;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String makeCarNames() {
        printStartMessage();
        return scanner.nextLine();
    }

    public static int makeGameRepeatCount() {
        printInputCountMessage();
        return scanner.nextInt();
    }
}