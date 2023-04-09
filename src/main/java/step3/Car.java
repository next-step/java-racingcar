package step3;

import java.util.ArrayList;
import java.util.List;

class Car {

    private final List<Car> cars = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    public Car(int count) {
        addCars(count);
    }

    public Car() {
    }

    public void move(int input) {
        if (input <= 3) {
            return;
        }
        sb.append("-");
    }

    public String getDistance() {
        return sb.toString();
    }

    public List<Car> getList() {
        return cars;
    }

    private void addCars(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
    }
}
