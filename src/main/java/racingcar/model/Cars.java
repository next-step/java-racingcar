package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    private Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars createWithNames(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = Car.create(name);
            cars.add(car);
        }

        return new Cars(cars);
    }

    public List<CarInformation> move() {
        List<CarInformation> informationList = new ArrayList<>();

        for (Car car : cars) {
            car.move();
            CarInformation information = car.getInformation();
            informationList.add(information);
        }

        return informationList;
    }

    public List<CarInformation> getCarInformationList() {
        return cars.stream()
                .map(Car::getInformation)
                .collect(Collectors.toList());
    }
}
