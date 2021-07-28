package racingCar.view;

import racingCar.utils.StringUtil;

import java.util.Scanner;

public class InputView {
    private static final String RACING_GAME_MESSAGE_INPUT_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACING_GAME_MESSAGE_PLAY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getCarNames() {
        System.out.println(RACING_GAME_MESSAGE_INPUT_NAMES);
        return StringUtil.divideByComma(scanner.nextLine());
    }

    public static int getPlayCount() {
        System.out.println(RACING_GAME_MESSAGE_PLAY_COUNT);
        return scanner.nextInt();
    }
}
