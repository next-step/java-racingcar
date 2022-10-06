package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        List<Car> winners = List.of(cars.get(0));

        for (int i = 1; i < cars.size(); i++) {
            winners = comparePositionAndGetWinners(winners, cars.get(i));
        }

        return winners.stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<Car> comparePositionAndGetWinners(List<Car> winners, Car car) {
        if (car.getPosition() > winners.get(0).getPosition()) {
            return List.of(car);
        }

        if (car.getPosition() == winners.get(0).getPosition()) {
            winners.add(car);
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
