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
        validateCarNameList(carNames);

        final int rounds = getRoundsToPlay();
        RacingCarGame racingCarGame = new RacingCarGame(carNames, rounds);

        racingCarGame.run();
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

    private static void validateCarNameList(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException("올바른 이름 값을 입력하세요.");
        }
    }

    private static int getRoundsToPlay() {
        OutputView.printTryCountSign();
        return InputView.getTryCount();
    }
}
