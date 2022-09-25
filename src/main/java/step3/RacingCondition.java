package step3;

import java.util.Scanner;

public class RacingCondition {
    private Integer carCount;
    private Integer attemptCount;

    public RacingCondition(Integer carCount, Integer attemptCount) {
        this.carCount = carCount;
        this.attemptCount = attemptCount;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public Integer getAttemptCount() {
        return attemptCount;
    }

    public static RacingCondition getInput() {
        Scanner scanner = new Scanner(System.in);

        int carCount = getIntInput(scanner, "자동차 대수는 몇 대 인가요?");
        int attemptCount = getIntInput(scanner, "시도할 회수는 몇 회 인가요?");

        return new RacingCondition(carCount, attemptCount);
    }

    private static int getIntInput(Scanner scanner, String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}