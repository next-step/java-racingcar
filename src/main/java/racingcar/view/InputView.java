package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String RACING_GAME_START_MESSAGE = "******** 자동차 레이싱 게임 ********";
    private static final String INPUT_CAR_NAME_MESSAGE = "경기에 참가하는 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_COUNT_OF_ROUND_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    private InputView() {
    }

    public static String getInputCarName() {
        System.out.println(RACING_GAME_START_MESSAGE);
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return scanner.nextLine().trim();
    }

    public static int getCountOfRacingRound() {
        System.out.println(INPUT_COUNT_OF_ROUND_MESSAGE);
        return scanner.nextInt();
    }
}
