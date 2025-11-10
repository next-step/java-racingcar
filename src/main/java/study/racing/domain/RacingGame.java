package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumber randomNumber;

    public RacingGame(int carCount, RandomNumber randomNumber) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.randomNumber = randomNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(randomNumber.generate());
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }


}
