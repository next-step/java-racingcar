package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {
    private List<Car> cars = new ArrayList<>();
    private static final int MAX_NUMBER = 4;

    public RacingCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public void racing() {
        for (Car car : cars) {
            int randomResult = randomNumber();
            tryMove(car, randomResult);
            System.out.println("-".repeat(car.getStatus()));
        }
        System.out.println();
    }

    public int randomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void tryMove(Car car, int number) {
        if (number >= MAX_NUMBER) {
            car.forward();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
