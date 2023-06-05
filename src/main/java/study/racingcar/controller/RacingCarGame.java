package study.racingcar.controller;

import study.racingcar.domain.Car;
import study.racingcar.domain.GameCars;
import study.racingcar.domain.Round;
import study.racingcar.domain.Winners;
import study.racingcar.strategy.NumberGenerator;
import study.racingcar.view.InputView;
import study.racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    private final GameCars cars;
    private final Round round;
    private final NumberGenerator numberGenerator;

    public RacingCarGame(NumberGenerator numberGenerator) {
        final List<String> carNames = getCarNames();
        final int rounds = getRoundsToPlay();

        this.cars = new GameCars(carNames);
        this.round = new Round(rounds);
        this.numberGenerator = numberGenerator;
    }

    private List<String> getCarNames() {
        OutputView.printCarNameSign();
        return InputView.getCarNames();
    }

    private int getRoundsToPlay() {
        OutputView.printTryCountSign();
        return InputView.getTryCount();
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
        if (Car.isMovable(numberGenerator)) {
            car.move();
        }
        OutputView.printCarNameAndStatus(car);
    }

    private void printGameResult() {
        Winners winners = cars.calculateWinner();
        OutputView.printGameResult(winners);
    }
}
