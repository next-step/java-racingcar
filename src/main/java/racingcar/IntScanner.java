package racingcar;

import java.util.Scanner;

public class IntScanner {
    public static Scanner scanner = new Scanner(System.in);

    public static int insertCarCount() {
        return scanner.nextInt();
    }

    public static int insertRaceCount() {
        return scanner.nextInt();
    }
}
