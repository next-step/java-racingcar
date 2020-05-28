package racingcar_step4;

import java.util.List;

public class CarRacingGame {

    private List<Car> cars;

    public CarRacingGame(List<Car> names) {
        this.cars = names;
    }

    public List<Car> runRacing() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
