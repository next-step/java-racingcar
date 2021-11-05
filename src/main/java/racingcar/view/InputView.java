package racingcar.view;

import racingcar.model.RacingGameRequest;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final static String INPUT_COUNT_OF_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final static String INPUT_COUNT_OF_TRY_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public RacingGameRequest inputRacingGame() {
        return new RacingGameRequest(inputCountOfCar(), inputCountOfTry());
    }
    private int inputCountOfCar() {
        System.out.println(INPUT_COUNT_OF_CAR_MESSAGE);
        return scanner.nextInt();
    }

    private int inputCountOfTry() {
        System.out.println(INPUT_COUNT_OF_TRY_MESSAGE);
        return scanner.nextInt();
    }
}
