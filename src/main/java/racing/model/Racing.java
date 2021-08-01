package racing.model;

import java.util.List;

public class Racing {

    private Cars cars = new Cars();

    public Racing(String[] carNames) {
        this.cars.prepareCars(carNames);
    }

    public List<Car> winnerCarList() {
        return cars.findWinner();
    }

    public void game() {
        cars.carsMove();
    }

    public List<String> getCarMoveLines() {
        return this.cars.getCarMoveLines();
    }

}
