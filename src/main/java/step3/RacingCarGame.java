package step3;

import java.util.Random;
import java.util.Scanner;

public class RacingCarGame {

    public static final Random RANDOM = new Random();

    public static String inputUsers() {
        return getInput();
    }

    public static String inputMovements() {
        return getInput();
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static Integer getRandomValue() {
        return RANDOM.nextInt(10);
    }

    public static Boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
