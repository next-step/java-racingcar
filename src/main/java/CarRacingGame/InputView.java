package CarRacingGame;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("Number of cars should be positive");
        }
        return numberOfCars;
    }

    public static int inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfAttempts = scanner.nextInt();
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("Number of attempts should be positive");
        }
        return numberOfAttempts;
    }
}
