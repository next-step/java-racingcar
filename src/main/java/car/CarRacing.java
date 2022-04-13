package car;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars = new ArrayList<Car>();
    private int attempt;
    private int moveMinNumber;

    public CarRacing(int participatingCarCount, int attempt, int moveMinNumber) {
        participatingCar(participatingCarCount);
        this.attempt = attempt;
        this.moveMinNumber = moveMinNumber;
    }

    private void participatingCar(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car("pobi"));
        }
    }

    public int getParticipatingCarCount() {
        return cars.size();
    }

    public int getAttemptCount() {
        return this.attempt;
    }

    public int getMoveMinNumber() {return this.moveMinNumber; }

    public List<Car> start() {
        for (int i = 0; i < attempt; i++) {
            for (Car car : cars) {
                car.move(4);
            }
        }

        return cars;
    }
}


