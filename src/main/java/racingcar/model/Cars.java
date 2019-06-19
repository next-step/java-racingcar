package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars createWithNames(List<CarName> names) {
        List<Car> cars = new ArrayList<>();

        for (CarName name : names) {
            Car car = Car.create(name);
            cars.add(car);
        }
        return new Cars(cars);
    }

    public List<CarInformation> move() {
        List<CarInformation> informationOnCars = new ArrayList<>();

        for (Car car : this.cars) {
            car.move();
            CarInformation information = car.getInformation();
            informationOnCars.add(information);
        }
        return informationOnCars;
    }

    public List<CarInformation> getInformationOnCars() {
        return cars.stream()
                .map(Car::getInformation)
                .collect(Collectors.toList());
    }
}
