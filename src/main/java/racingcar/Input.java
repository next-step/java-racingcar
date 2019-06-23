package racingcar;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String getCarNames() {
        return scanner.nextLine();
    }

    public static int getTimes() {
        return scanner.nextInt();
    }
}
