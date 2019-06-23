package racingcar;

import racingcar.domain.RacingCars;
import racingcar.domain.Winners;
import racingcar.domain.moving.DefaultMovingStrategy;
import racingcar.domain.moving.MovingStrategy;
import racingcar.domain.RacingCar;
import racingcar.domain.moving.Position;
import racingcar.domain.moving.RandomValueProvider;
import racingcar.view.input.InputView;
import racingcar.view.result.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final InputView inputView;
    private final ResultView resultView;

    private final MovingStrategy movingStrategy;
    private List<RacingCar> racingCars;
    private Integer numberOfTimes;

    RacingGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.movingStrategy = new DefaultMovingStrategy(new RandomValueProvider(10));
    }

    public void race() {
        initGame();
        startGame();
        printResult();
    }

    private void initGame() {
        racingCars = inputView.getCarNames().stream()
                .map(name -> RacingCar.of(name, Position.of(0)))
                .collect(Collectors.toList());

        numberOfTimes = inputView.getNumberOfTimes();
    }

    private void startGame() {
        resultView.printHeader();
        for (int i = 0; i < numberOfTimes; i++) {
            move();
            resultView.printBody(racingCars);
        }
    }

    private void move() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move(movingStrategy);
        }
    }

    private void printResult() {
        List<RacingCar> winners = RacingCars.of(racingCars).findWinners();
        resultView.printFooter(Winners.of(winners));
    }
}
