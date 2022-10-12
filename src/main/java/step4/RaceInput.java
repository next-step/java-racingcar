package step4;

import java.util.Scanner;

public class RaceInput {

    private final String[] nameOfCars;

    private final int numberOfTries;

    private static final Scanner scanner = new Scanner(System.in);

    private static final String SEPARATOR = ",";

    public RaceInput() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표를 기준으로 구분)");
        this.nameOfCars = scanner.next().split(SEPARATOR);
        System.out.println("시도할 횟수는 몇 회 인가요?");
        this.numberOfTries = Integer.parseUnsignedInt(scanner.next());
        System.out.println();
    }

    public String[] nameOfCars() {
        return this.nameOfCars;
    }

    public int numberOfTries() {
        return this.numberOfTries;
    }
}
