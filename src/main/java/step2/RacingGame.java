package step2;

import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> move() {
        cars.forEach((car) -> {
            int carPositionStatusNumber = Utils.createRandomNumber();
            car.carPositionUpdate(carPositionStatusNumber);
        });
        return cars;
    }

}