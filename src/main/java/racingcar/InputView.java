package racingcar;

import java.util.Scanner;

public class InputView {
    public static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    public static final String TRY_COUNT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public void getUserInput() {
        getNumberOfCars();
        getNumberOfTries();
    }

    private InputValidation getNumberOfCars() {
        System.out.println(CAR_COUNT_QUESTION);
        return new InputValidation(scanner.nextLine());
    }

    private InputValidation getNumberOfTries() {
        System.out.println(TRY_COUNT_QUESTION);
        return new InputValidation(scanner.nextLine());
    }
}
