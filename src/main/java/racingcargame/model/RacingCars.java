package racingcargame.model;

import java.util.List;

public class RacingCars {
    List<RacingCar> cars;
    RandomNumber randomNumber = new RandomNumber();

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public void playRound() {
        for (RacingCar car : cars) {
            car.move(randomNumber.getNumber());
        }
    }

    public int findMaxScore() {
        int maxScore = 0;
        for (RacingCar car : cars) {
            if (maxScore < car.getStep()) {
                maxScore = car.getStep();
            }
        }
        return maxScore;
    }

    public String findWinners(int maxScore) {
        String winners = "";
        for (RacingCar car : cars) {
            if (car.isWinner(maxScore)) {
                winners += " " + car.getName() + ",";
            }
        }
        winners = winners.substring(0, winners.length() - 1);
        return winners;
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}
