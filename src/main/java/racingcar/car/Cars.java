package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String names[]) {
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
    }

    public Cars(List<Car> cars) {
        for (Car car : cars) {
            this.cars.add(new Car(car.getName(), car.getPosition()));
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


}
