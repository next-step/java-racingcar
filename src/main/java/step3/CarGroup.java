package step3;

import java.util.Arrays;
import java.util.Random;

public class CarGroup {
    private Random random = new Random();
    private Car[] cars;

    public CarGroup(int carCount) {
        this.cars = new Car[carCount];
    }

    public void move() {
        Arrays.stream(cars)
                .forEach(car -> car.moveIf(random.nextInt()));
    }

    public void show() {
        Arrays.stream(cars)
                .forEach(Car::show);
    }
}
