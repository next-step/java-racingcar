package study.step3;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private int carCount;
    private int attemptCount;

    public void inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?\n");
        carCount = scanner.nextInt();
    }

    public void inputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇 회 인가요?\n");
        attemptCount = scanner.nextInt();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
