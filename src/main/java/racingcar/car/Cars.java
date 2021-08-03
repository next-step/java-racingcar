package racingcar.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String names[]) {
        cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getWinnerCars() {
        int maxPosition = Collections.max(cars).getPosition();
        return cars.stream().filter(c -> c.getPosition() == maxPosition).collect(Collectors.toList());
    }

}
