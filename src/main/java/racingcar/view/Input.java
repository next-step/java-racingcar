package racingcar.view;

import java.util.Scanner;

public class Input {
    private static final String GET_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCarNames() {
        System.out.println(GET_CAR_NAMES_MSG);
        return scanner.nextLine();
    }

    public int getTryCount() {
        System.out.println(GET_TRY_COUNT_MSG);
        return scanner.nextInt();
    }
}
