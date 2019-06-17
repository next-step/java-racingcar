package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            Car car = Car.create(name);
            cars.add(car);
        }
    }

    public List<CarInformation> move() {
        List<CarInformation> informationList = new ArrayList<>();

        for (Car car : cars) {
            String name = car.toString();
            Position position = car.move();

            CarInformation information = new CarInformation(name, position);
            informationList.add(information);
        }

        return informationList;
    }
}
