package study.racingcar.controller;

import study.racingcar.view.InputView;
import study.racingcar.view.OutputView;
import study.racingcar.domain.RacingCarGame;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public static final String CAR_NAME_DELIMITER = ",";

    /**
     * 게임 실행을 담당한다
     */
    public static void main(String[] args) {
        final List<String> carNames = getCarNames();
        final int rounds = getRoundsToPlay();
        RacingCarGame racingCarGame = new RacingCarGame(carNames, rounds);
        racingCarGame.run();
    }

    private static int getRoundsToPlay() {
        OutputView.printTryCountSign();
        return InputView.getTryCount();
    }

    private static List<String> getCarNames() {
        OutputView.printCarNameSign();
        String carNames = InputView.getCarNames();
        return convertToList(carNames);
    }

    private static List<String> convertToList(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());
    }
}
