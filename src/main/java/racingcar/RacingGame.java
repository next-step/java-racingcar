package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final static int MAX_BOUND = 10;
    private final static int MOVABLE_THRESHOLD = 4;

    private final List<Car> cars;
    private final Random random;

    public RacingGame() {
        this.cars = new ArrayList<>();
        this.random = new Random();
    }

    public void createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public void createCars(List<String> names) {
        for (String name: names) {
            cars.add(new Car(name));
        }
    }

    public void tryGame() {
        for (Car car : cars) {
            if (isMovable()) {
                car.forward();
            }
        }
    }

    protected boolean isMovable() {
        return random.nextInt(MAX_BOUND) >= MOVABLE_THRESHOLD;
    }

    public List<String> getWinnerNames() {
        int maxPosition = findMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car: cars) {
            comparePositionAndAddWinners(winners, car, maxPosition);
        }

        return winners;
    }

    private void comparePositionAndAddWinners(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    private int findMaxPosition() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .orElseThrow()
            .getPosition();
    }

    public List<Car> getCars() {
        return cars;
    }
}
