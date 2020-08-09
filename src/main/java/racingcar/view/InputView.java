package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String RACING_GAME_TITLE = "******** 자동차 레이싱 게임 ********";
    private static final String INPUT_NAME_MESSAGE = "경기에 참가하는 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_ROUND_MESSAGE = "경기는 몇 ROUND 까지 진행하나요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getInputCarName() {
        System.out.println(RACING_GAME_TITLE);
        System.out.println(INPUT_NAME_MESSAGE);
        String inputCarName = scanner.nextLine().trim();
        return inputCarName;
    }

    public static String getRacingRound() {
        System.out.println(INPUT_ROUND_MESSAGE);
        return scanner.nextLine().trim();
    }

}
