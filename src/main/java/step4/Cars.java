package step4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    Cars(final String[] names) {
        addCars(names);
    }

    void addCars(String[] names) {
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    int getCarsSize() {
        return cars.size();
    }

    Car getCar(int index) {
        return cars.get(index);
    }

    Car findMaxValue() {
        return cars.stream().max(Comparator.comparing(Car::getPosition)).get();
    }
}
