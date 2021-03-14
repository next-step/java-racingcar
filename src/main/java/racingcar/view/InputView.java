package racingcar.view;

import java.util.Scanner;

public enum InputView {

    INSTANCE;

    private final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private final String INPUT_HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public String InputNumberOfCars() {
        System.out.println(INPUT_HOW_MANY_CARS);
        return scanner.nextLine().trim();
    }

    public String InputNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        return scanner.nextLine().trim();
    }
}
