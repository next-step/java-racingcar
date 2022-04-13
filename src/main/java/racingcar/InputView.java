package racingcar;

import java.util.Random;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int getNumber(String payload) {
        System.out.printf("How many %s?\n", payload);
        int number = scanner.nextInt();
        if (!isInputRange(number)) throw new RuntimeException("outOfRange");
        return number;
    }

    public static boolean isInputRange(int i) {
        return 0 < i && i < 10;
    }

}
