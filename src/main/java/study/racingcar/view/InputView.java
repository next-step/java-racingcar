package study.racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String NUMBER_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_GAME_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_NAMES_OF_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_RESET_MESSAGE = "게임을 다시 시작하시겠습니까?(Y:다시시작, N:종료)";
    private static final String YES = "Y";
    private static final Scanner INPUT = new Scanner(System.in);

    public InputView() {}

    public int setCars() {
        System.out.println(NUMBER_OF_CAR_MESSAGE);

        return inputNumber();
    }

    public int setGames() {
        System.out.println(NUMBER_OF_GAME_MESSAGE);

        return inputNumber();
    }

    public String setCarNames() {
        System.out.println(CAR_NAMES_OF_MESSAGE);

        return inputString();
    }

    private int inputNumber() {
        return INPUT.nextInt();
    }

    private String inputString() {
        return INPUT.next();
    }

    public boolean reset() {
        System.out.println(GAME_RESET_MESSAGE);

        return isReset(inputString());
    }

    private boolean isReset(String text) {
        return text.equals(YES);
    }
}
