package carRacingGame;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String splitter = ",";
    public static String[] inputNameOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameOfCars = scanner.next();
        if (!(nameOfCars instanceof String)) {
            throw new IllegalArgumentException("Name of cars should be string type");
        }
        String[] listedCars = nameOfCars.split(splitter);

        return listedCars;
    }
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
