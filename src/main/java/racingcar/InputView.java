package racingcar;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static Scanner scanner = new Scanner(System.in);
    private Number carCount;
    private Number tryCount;

    public InputView() {
        this.carCount = askNumberOfCars();
        this.tryCount = askNumberOfTries();
    }

    private Number askNumberOfCars() {
        System.out.println(CAR_COUNT_QUESTION);
        return new Number(scanner.nextLine());
    }

    private Number askNumberOfTries() {
        System.out.println(TRY_COUNT_QUESTION);
        return new Number(scanner.nextLine());
    }

    public int getCarCount() {
        return carCount.getNumber();
    }

    public int getTryCount() {
        return tryCount.getNumber();
    }
}
