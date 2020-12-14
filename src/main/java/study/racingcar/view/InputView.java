package study.racingcar.view;

import java.util.Scanner;

public class InputView {

    public static final String RACING_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String RACING_GAMES_TRY_NUMBER_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final Scanner scanner = new Scanner(System.in);

    public String inputRacingParticipantByName() {
        System.out.println(RACING_CAR_NAMES_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public int inputTryNo() {
        System.out.println(RACING_GAMES_TRY_NUMBER_MESSAGE);
        return scanner.nextInt();
    }

}
