package study.racingcar.controller;

import study.racingcar.domain.Car;
import study.racingcar.domain.GameCars;
import study.racingcar.domain.Round;
import study.racingcar.domain.Winners;
import study.racingcar.strategy.RandomNumberGenerator;
import study.racingcar.view.InputView;
import study.racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {
    public static final RandomNumberGenerator NUMBER_GENERATOR = new RandomNumberGenerator();
    private final GameCars cars;
    private final Round round;

    public RacingCarGame() {
        final List<String> carNames = getCarNames();
        final int rounds = getRoundsToPlay();

        this.cars = new GameCars(carNames);
        this.round = new Round(rounds);
    }

    public void run() {
        OutputView.printResultSign();
        for (int i = 0; i < round.getTotalRounds(); i++) {
            playTheGame(cars);
        }
        printGameResult();
    }

    private List<String> getCarNames() {
        OutputView.printCarNameSign();
        return InputView.getCarNames();
    }

    private int getRoundsToPlay() {
        OutputView.printTryCountSign();
        return InputView.getTryCount();
    }

    private void playTheGame(GameCars cars) {
        cars.forEach(this::execute);
        OutputView.printBlankLine();
    }

    private void execute(Car car) {
        if (Car.isMovable(NUMBER_GENERATOR)) {
            car.move();
        }
        OutputView.printCarNameAndStatus(car);
    }

    private void printGameResult() {
        Winners winners = cars.calculateWinner();
        OutputView.printGameResult(winners);
    }
}
