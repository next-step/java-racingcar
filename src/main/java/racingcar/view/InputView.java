package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public static String inputCarName() {
        System.out.println(CAR_NAME_MESSAGE);

        return input();
    }

    public static int inputGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);

        return inputInt();
    }

    private static String input() {
        return SCANNER.next();
    }

    private static int inputInt() {
        return SCANNER.nextInt();
    }
}
