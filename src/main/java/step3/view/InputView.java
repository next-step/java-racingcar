package step3.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_OF_RACINGCAR_NUMBER = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분합니다.";
    private static final String INPUT_OF_GAME_COUNT = "시도할 회수는 몇 회 인가요?";

    public static String setRacingCarNumber(Scanner scanner) {
        System.out.println(INPUT_OF_RACINGCAR_NUMBER);
        return scanner.nextLine();
    }

    public static int setMotorRacingCount(Scanner scanner) {
        System.out.println(INPUT_OF_GAME_COUNT);
        return scanner.nextInt();
    }

}
