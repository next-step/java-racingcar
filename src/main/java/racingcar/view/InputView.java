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

    public static int inputGameRound() {
        System.out.println(GAME_COUNT_MESSAGE);
        int input;

        try {
            input = Integer.parseInt(input());
        } catch (Exception e) {
            throw new NumberFormatException("정수를 입력 해주세요");
        }

        return input;
    }

    private static String input() {
        return SCANNER.nextLine();
    }
}
