package racing.model;

import java.util.List;

public class Racing {

    private Cars cars = new Cars();


    public Racing(String[] carNames) {
        this.cars.prepareCars(carNames);
    }

    public List<Car> winnerCarList() {
        return cars.findWinners();
    }

    public List<Car> game() {
        return cars.carsMove();
    }
}
