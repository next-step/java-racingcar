package racingcar.view;

import java.util.Scanner;

public enum InputView {

    INSTANCE;

    private final String INPUT_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇 회 인가요?";
    private final String INPUT_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final Scanner scanner = new Scanner(System.in);

    public String InputNameOfCars() {
        System.out.println(INPUT_NAME_OF_CARS);
        return scanner.nextLine().trim();
    }

    public String InputNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        return scanner.nextLine().trim();
    }
}
