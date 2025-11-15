package racingCar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class CarRace {
    private static final int RANDOM_MAX_NUM = 10;
    private final List<Car> cars;
    private final Random random;

    public CarRace(String names) {
        random = new Random();
        cars = createCars(names);
    }
    private List<Car> createCars(String names) {
        List<Car> carList = new ArrayList<>();
        for(String name : split(names)) {
            carList.add(new Car(name));
        }

        return carList;
    }
    private String[] split(String names) {
        return names.split(",");
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void play() {
        for (Car car : this.cars) {
            car.move(getRandomNum());
        }
    }

    public List<Car> getWinners() {
        return Winners.getWinners(cars);
    }

    private int getRandomNum() {
        return random.nextInt(RANDOM_MAX_NUM);
    }
}
