package racingCar.domain;

import java.util.List;

public class CarRace {
    private final Cars cars;

    public CarRace(String[] names) {
        this(new Cars(names));
    }

    public CarRace(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars.value();
    }

    public void play() {
        this.cars.play();
    }

    public Winners getWinners() {
        return cars.getWinners();
    }
}
