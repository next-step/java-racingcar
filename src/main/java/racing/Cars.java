package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] names) {
        createCars(names);
    }

    private void createCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public Cars go() {
        List<Car> raceRecord = new ArrayList<>();
        for (Car car : cars) {
            raceRecord.add(car.move(new MoveStrategyImpl()));
        }

        return new Cars(raceRecord);
    }

    public int size() {
        return cars.size();
    }
}
