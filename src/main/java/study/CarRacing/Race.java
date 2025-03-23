package study.CarRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public Race(int numberOfCars, MovingStrategy movingStrategy) {
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.");
        }
        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
        this.movingStrategy = movingStrategy;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound(Random random) {
        for (Car car : cars) {
            int randomNumber = random.nextInt(10);
            boolean canMove = movingStrategy.canMove(randomNumber);
            car.move(canMove);
        }
    }
}
