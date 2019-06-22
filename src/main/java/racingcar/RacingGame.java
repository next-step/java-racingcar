package racingcar;

import racingcar.domain.moving.MovingStrategy;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.input.InputView;
import racingcar.view.result.ResultView;

import java.util.stream.Collectors;

public class RacingGame {

    private final InputView inputView;
    private final ResultView resultView;
    private final MovingStrategy movingStrategy;

    private RacingCars racingCars;
    private Integer numberOfTimes;

    RacingGame(InputView inputView, ResultView resultView, MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.movingStrategy = movingStrategy;
    }

    public void run() {
        initGame();
        startGame();
        showResult();
    }

    private void initGame() {
        /*
        racingCars = RacingCars.of(
                inputView.getCarNames().stream()
                .map(name -> RacingCar.of(name, movingStrategy))
                .collect(Collectors.toList())
        );
        */
        numberOfTimes = inputView.getNumberOfTimes();
    }

    private void startGame() {
        resultView.printHeader();
        /*
        for (int i=0; i<numberOfTimes; i++) {
            racingCars.move();
            resultView.printBody(racingCars);
        }
        */
    }

    private void showResult() {
        resultView.printFooter(racingCars);
    }
}
