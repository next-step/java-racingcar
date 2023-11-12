package racing;

import racing.domain.Cars;
import racing.view.ResultView;

public class Racing {

    private Cars cars;
    private int round;

    public Racing(String[] carNames, int round) {
        this.cars = Cars.createCars(carNames);
        this.round = round;
    }

    public Cars getCars() {
        return cars;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            cars.tryMove();
            ResultView.carStatus(cars);
        }
    }

    public Cars winners() {
        return cars.findWinners();
    }
}
