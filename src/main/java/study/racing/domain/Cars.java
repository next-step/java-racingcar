package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars from(List<String> names) {
        return new Cars(createCars(names));
    }

    private static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void playRound(RandomNumber randomNumber) {
        for (Car car : cars) {
            car.move(new Torque(randomNumber.generate()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners getWinners() {
        return Winners.from(cars);
    }
}
