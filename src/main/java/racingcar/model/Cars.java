package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public Cars(String[] names) {
        this.cars = new ArrayList<Car>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveCars(){
        for (Car car : cars) {
            car.move(RandomPicker.getRandomNumberInRange(9));
        }
    }
}
