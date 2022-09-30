package step3;

import java.util.Scanner;

public class RaceInput {

    private final int numberOfCar;

    private final int numberOfTry;

    private static final Scanner scanner = new Scanner(System.in);

    public RaceInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.numberOfCar = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.numberOfTry = scanner.nextInt();
        System.out.println();
    }

    public int numberOfCar() {
        return numberOfCar;
    }

    public int numberOfTry() {
        return numberOfTry;
    }
}
