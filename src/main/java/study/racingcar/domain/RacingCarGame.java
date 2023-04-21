package study.racingcar.domain;

import study.racingcar.rule.DomainRule;
import study.racingcar.strategy.NumberGenerator;
import study.racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    private final GameCars cars;
    private final Round round;
    private final Result gameResult;
    private final DomainRule rule;

    public RacingCarGame(List<String> carNames, int roundToPlay, NumberGenerator numberGenerator) {
        this.cars = new GameCars(carNames);
        this.round = new Round(roundToPlay);
        this.gameResult = new Result(cars);
        this.rule = new DomainRule(numberGenerator);
    }

    public RacingCarGame(List<String> carNames, int roundToPlay) {
        this.cars = new GameCars(carNames);
        this.round = new Round(roundToPlay);
        this.gameResult = new Result(cars);
        this.rule = new DomainRule();
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
        if (Car.isMovable(rule)) {
            car.move();
        }
        OutputView.printCarNameAndStatus(car);
    }

    private void printGameResult() {
        Winners winners = gameResult.winners();
        OutputView.printGameResult(winners);
    }
}
