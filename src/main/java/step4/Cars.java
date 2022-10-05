package step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCars(String[] names) {
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public Car getCar(int index) {
        return cars.get(index);
    }

    public Car findMaxValue() {
        return cars.stream().max(Comparator.comparing(Car::getPosition)).get();
    }
}
