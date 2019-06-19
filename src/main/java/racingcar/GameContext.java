package racingcar;

import racingcar.logic.CarEngine;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.input.InputView;
import racingcar.view.result.ResultView;

import java.util.stream.Collectors;

public class GameContext {

    private final InputView inputView;
    private final ResultView resultView;
    private final CarEngine carEngine;

    private RacingCars racingCars;
    private Integer numberOfTimes;

    GameContext(InputView inputView, ResultView resultView, CarEngine carEngine) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.carEngine = carEngine;
    }

    public void run() {
        initGame();
        startGame();
        showResult();
    }

    private void initGame() {
        racingCars = RacingCars.of(
                inputView.getCarNames().stream()
                .map(name -> RacingCar.of(name, carEngine))
                .collect(Collectors.toList())
        );
        numberOfTimes = inputView.getNumberOfTimes();
    }

    private void startGame() {
        resultView.printHeader();
        for (int i=0; i<numberOfTimes; i++) {
            racingCars.move();
            resultView.printBody(racingCars);
        }
    }

    private void showResult() {
        resultView.printFooter(racingCars);
    }
}
