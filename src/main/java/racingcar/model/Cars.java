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
            car.move();
            CarInformation information = car.getInformation();
            informationList.add(information);
        }

        return informationList;
    }
}
