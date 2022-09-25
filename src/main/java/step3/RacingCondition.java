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
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int attemptCount = scanner.nextInt();

        return new RacingCondition(carCount, attemptCount);
    }
}