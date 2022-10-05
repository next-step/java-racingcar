package step3;

import java.util.Scanner;

public class RaceInput {

    private final int numberOfCar;

    private final int numberOfTry;

    private static final Scanner scanner = new Scanner(System.in);

    public RaceInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.numberOfCar = Integer.parseUnsignedInt(scanner.next());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.numberOfTry = Integer.parseUnsignedInt(scanner.next());
        System.out.println();
    }

    public int numberOfCar() {
        return this.numberOfCar;
    }

    public int numberOfTry() {
        return this.numberOfTry;
    }
}
