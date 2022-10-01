package racingcar.model;

import racingcar.model.nickname.Nickname;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        return new Cars(initCars(names));
    }

    private static List<Car> initCars(List<String> names) {
        return names.stream()
                .map(name -> new Car(new Nickname(name)))
                .collect(Collectors.toList());
    }

    public List<Car> move() {
        cars.forEach(car -> car.move(new CarCondition()));
        return List.copyOf(cars);
    }

    public List<Car> getWinners() {
        return List.copyOf(Car.getWinner(cars));
    }
}
