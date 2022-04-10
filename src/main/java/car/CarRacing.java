package car;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarRacing {
    private ArrayList<Car> cars = new ArrayList<Car>();
    private int attempt;

    public CarRacing(int participatingCarCount, int attempt) {
        participatingCar(participatingCarCount);
        this.attempt = attempt;
    }

    private void participatingCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public int getParticipatingCarCount() {
        return cars.size();
    }

    public int getAttemptCount() {
        return this.attempt;
    }

    public ArrayList<Car> start() {
        for (int i = 0; i < attempt; i++) {
            for (Car car : cars) {
                car.move(car.randomNumber());
            }
        }

        return cars;
    }
}


