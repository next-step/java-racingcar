package racingCar;

import java.util.List;

public class CarRace {
    private final Cars cars;
    private final RandomNumber random;

    public CarRace(String[] names) {
        this(new RandomNumber(), new Cars(names));
    }

    public CarRace(RandomNumber random, Cars cars) {
        this.random = random;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars.value();
    }

    public void play() {
        for (Car car : this.cars.value()) {
            car.move(getRandomNum());
        }
    }

    public Winners getWinners() {
        return cars.getWinners();
    }

    private int getRandomNum() {
        return random.getRandomNum();
    }

    public int carNos() {
        return this.cars.value().size();
    }
}
