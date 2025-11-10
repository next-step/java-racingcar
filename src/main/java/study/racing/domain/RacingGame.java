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

    public List<String> getWinners() {
        int maxPosition = findMaxPosition();
        return findWinnersNames(maxPosition);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<String> findWinnersNames(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}
