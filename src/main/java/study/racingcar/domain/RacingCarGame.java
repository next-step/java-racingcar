package study.racingcar.domain;

import study.racingcar.rule.Rule;
import study.racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    private final GameCars cars;
    private final Round round;
    private final Result gameResult;

    public RacingCarGame(List<String> carNames, int roundToPlay) {
        this.cars = new GameCars(carNames);
        this.round = new Round(roundToPlay);
        this.gameResult = new Result(cars);
    }

    public void run() {
        OutputView.printResultSign();
        for (int i = 0; i < round.getTotalRounds(); i++) {
            playTheGame(cars);
        }
        printGameResult();
    }

    private void playTheGame(GameCars cars) {
        cars.forEach(this::execute);
        OutputView.printBlankLine();
    }

    private void execute(Car car) {
        if (Car.isMovable(Rule.numberGenerator())) {
            car.move();
        }
        OutputView.printCarStatus(car);
    }

    private void printGameResult() {
        String winners = gameResult.winners();
        OutputView.printGameResult(winners);
    }
}
