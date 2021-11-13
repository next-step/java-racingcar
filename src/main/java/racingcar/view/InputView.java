package racingcar.view;

import static racingcar.utils.PrintUtils.print;

import java.util.Scanner;
import racingcar.dto.GameConfig;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    private static final String NUMBER_OF_CAR_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_GAME_ROUND_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";


    public GameConfig initConfig() {

        int numberOfCar = inputFromClient(NUMBER_OF_CAR_INPUT_MESSAGE);
        int numberOfGameRound = inputFromClient(NUMBER_OF_GAME_ROUND_INPUT_MESSAGE);

        return new GameConfig(numberOfCar, numberOfGameRound);
    }

    private int inputFromClient(String message) {
        print(message);
        return sc.nextInt();
    }

}
