package racingcar;

import racingcar.domain.RacingCar;
import racingcar.dto.Input;
import racingcar.inputview.InputHandler;
import racingcar.resultview.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    private final InputHandler inputHandler;
    private final ResultView resultView;

    public RacingCarGame(InputHandler inputHandler, ResultView resultView) {
        this.inputHandler = inputHandler;
        this.resultView = resultView;
    }

    public void start() {
        Input input = inputHandler.getInput();
        List<RacingCar> racingCars = input.toRacingCars();

        for (int i = 0; i < input.numberOfCountToTry; i++) {
            tryToMoveRacingCars(racingCars);
            resultView.printProgress(racingCars);
        }

        Collections.sort(racingCars);
        RacingCar winner = racingCars.get(0);
        List<RacingCar> winners = racingCars.stream()
                .filter(rc -> rc.isSameMoveCount(winner))
                .collect(Collectors.toList());
        resultView.printWinners(winners);
    }

    private void tryToMoveRacingCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.tryToMove();
        }
    }
}
