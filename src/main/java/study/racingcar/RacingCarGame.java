package study.racingcar;

import study.racingcar.utils.GameUtils;

public class RacingCarGame {
    /**
     * 게임을 진행을 담당한다.
     */
    private final GameCars cars;
    private final Round round;

    public RacingCarGame(int numOfCar, int roundToPlay) {
        this.cars = new GameCars(numOfCar);
        this.round = new Round(roundToPlay);
    }

    public void run() {
        OutputView.printResultSign();
        for (int i = 0; i < round.getTotalRounds(); i++) {
            playTheGame(cars);
        }
    }

    private void playTheGame(GameCars cars) {
        for (Car car : cars) {
            execute(car);
        }
        OutputView.printBlankLine();
    }

    private void execute(Car car) {
        int randomValue = GameUtils.randomNumber();

        if (Car.isMovable(randomValue)) {
            car.move();
        }
        OutputView.printCarStatus(car);
    }
}
