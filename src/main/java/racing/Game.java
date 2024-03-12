package racing;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final static int DEFAULT_START_LOCATION = 1;
    private final List<Car> attendedCars;

    Game() {
        this.attendedCars = new ArrayList<>();
    }

    public List<Car> getAttendedCars() {
        return attendedCars;
    }

    public void createAttendedCars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            attendedCars.add(new Car(i + 1 + "번 자동차", DEFAULT_START_LOCATION));
        }
    }

    public void playGame(int numberOfAttempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            this.playSession();
            Output.showSessionStatus(this);
        }
    }

    private void playSession() {
        for (Car car : attendedCars) {
            car.drive();
        }
    }
}
