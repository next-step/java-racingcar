package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;

    public Race(String[] carNames) {
        createCars(carNames);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void createCars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            this.cars.add(new Car(carNames[i], new RandomMoveStrategy()));
        }
    }

    public void round() {
        for (Car car : this.cars) {
            car.run();
        }
    }
}
