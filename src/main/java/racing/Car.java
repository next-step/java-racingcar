package racing;

import java.util.ArrayList;
import java.util.List;

public class Car {

    public static final int FORWARD_CONDITION = 4;
    private int number;
    private int distance;

    public Car(int number) {
        this.number = number;
        this.distance = 0;
    }

    public Car() {
    }

    public int carNumber() {
        return number;
    }

    public int carDistance() {
        return distance;
    }

    public void move(int random) {
        if (random >= FORWARD_CONDITION) {
            distance += 1;
        }
    }

    public List<Car> generateCar(int number) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
        return cars;
    }
}
