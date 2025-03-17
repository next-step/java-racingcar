package racingcar;

import java.util.Scanner;

public class RacingCarInput {

    private static final Scanner SCANNER = new Scanner(System.in);
    private final int carCount;
    private final int tryCount;

    public RacingCarInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carCount = SCANNER.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryCount = SCANNER.nextInt();
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
