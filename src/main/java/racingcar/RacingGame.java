package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.ResultView;

public class RacingGame {
    private final int round;
    private final Cars cars = new Cars();

    public RacingGame(String carNames, int round) {
        this.round = round;
        initCars(carNames.split(","));

    }

    public void race() {
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            ResultView.printRoundResult(cars);
        }
        ResultView.printWinnerNames(cars.findWinners());
    }


    private void initCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.addCar(new Car(carName));
        }
    }


}
