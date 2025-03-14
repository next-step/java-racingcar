package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int START_POSITION = 1;
    private int position;

    public Car() {
        this.position = START_POSITION;
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
