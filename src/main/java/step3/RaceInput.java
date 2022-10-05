package step3;

import java.util.Scanner;

public class RaceInput {
    private final int numberOfCar;
    private final int tryCount;
    private static final Scanner sc = new Scanner(System.in);

    public RaceInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.numberOfCar = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.tryCount = sc.nextInt();
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getTryCount() {
        return tryCount;
    }
}
