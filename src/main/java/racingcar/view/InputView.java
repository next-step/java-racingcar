package racingcar.view;

import racingcar.model.RacingGameRequest;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final static String INPUT_COUNT_OF_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static String INPUT_COUNT_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public RacingGameRequest inputRacingGame() {
        return new RacingGameRequest(inputCarNames(), inputCountOfTry());
    }

    private String inputCarNames() {
        System.out.println(INPUT_COUNT_OF_CAR_MESSAGE);
        return scanner.nextLine();
    }

    private int inputCountOfTry() {
        System.out.println(INPUT_COUNT_OF_TRY_MESSAGE);
        return scanner.nextInt();
    }
}
