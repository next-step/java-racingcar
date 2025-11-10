package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final RandomNumber randomNumber;

    public RacingGame(List<String> carNames, RandomNumber randomNumber) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
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

    public Winners getWinners() {
        return new Winners(cars);
    }
}
