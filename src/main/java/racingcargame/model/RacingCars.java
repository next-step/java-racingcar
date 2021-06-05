package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    List<RacingCar> cars;
    RandomNumber randomNumber = new RandomNumber();

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (RacingCar car : cars) {
            car.move(randomNumber.createRandomNumber());
        }
    }

    public int findMaxScore() {
        int maxScore = 0;
        for (RacingCar car : cars) {
            Math.max(maxScore, car.getStep());
        }
        return maxScore;
    }

    public String findWinners(int maxScore) {
        List<String> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            if (car.isWinner(maxScore)) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}
