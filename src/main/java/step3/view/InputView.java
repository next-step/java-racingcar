package step3.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_GAME_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAME_REQUEST_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputGameRoundCount() {
        System.out.println(INPUT_GAME_COUNT_REQUEST_MESSAGE);
        return scanner.nextInt();
    }
}
