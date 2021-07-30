package racing.model;


import java.util.List;

public class Racing {

    private Cars cars = new Cars();

    public Racing(String[] carNames) {
        this.cars.prepareCars(carNames);
    }

    public Racing(List<Car> cars) {
        this.cars.prepareCars(cars);
    }

    public List<Car> winnerCarList() {
        return cars.winner();
    }

    public void game() {
        cars.carsMove();
    }
}
