package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    int position;

    public Car() {
        this.position = 1;
    }

    public int active(boolean canProgress) {
        if (canProgress) {
            this.position++;
        }
        return this.position;
    }

    public static List<Car> createCars(int size) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
