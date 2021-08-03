package racingcar.view;

import racingcar.util.StringUtils;

import java.util.Scanner;

public class InputView {
    private static final String ASK_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private final static Scanner scanner = new Scanner(System.in);

    public String[] askCarsName() {
        System.out.println(ASK_CARS_NAME);
        return StringUtils.split(scanner.nextLine());
    }

    public int askTryCount() {
        System.out.println(ASK_TRY_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }
}
