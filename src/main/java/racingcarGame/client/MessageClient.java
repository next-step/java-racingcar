package racingcarGame.client;

import java.util.Scanner;

public class MessageClient {

    private static final Scanner scanner = new Scanner(System.in);

    public static void show(String message) {
        System.out.println(message);
    }

    public static void nextLine() {
        System.out.println();
    }

    public static int input() {
        return scanner.nextInt();
    }
}
