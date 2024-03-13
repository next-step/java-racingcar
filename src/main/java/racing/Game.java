package racing;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Car> attendedCars;
    private final RandomGenerator randomGenerator;

    public Game() {
        this.attendedCars = new ArrayList<>();
        this.randomGenerator = new RandomGenerator();
    }

    public List<Car> getAttendedCars() {
        return attendedCars;
    }

    public void createAttendedCars(int numberOfCar) {
        for (int i = 0; i < numberOfCar; i++) {
            attendedCars.add(new Car(i + 1 + "번 자동차"));
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
            car.move(randomGenerator.getRandomMovePoint());
        }
    }
}
