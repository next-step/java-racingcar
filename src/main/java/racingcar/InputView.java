package racingcar;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static Scanner scanner = new Scanner(System.in);
    private int numberOfCars;
    private int numberOfTries;

    public InputView() {
        this.numberOfCars = getUserCarCount();
        this.numberOfTries = getUserTries();
    }

    private int getUserCarCount() {
        System.out.println(CAR_COUNT_QUESTION);
        return new Number(scanner.nextLine()).getNumber();
    }

    private int getUserTries() {
        System.out.println(TRY_COUNT_QUESTION);
        return new Number(scanner.nextLine()).getNumber();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}
