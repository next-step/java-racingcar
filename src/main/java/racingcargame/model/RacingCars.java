package racingcargame.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {

    private List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public Histories playGame(int roundNumber) {
        List<History> histories = new ArrayList<>();
        for (int i = 0; i < roundNumber; i++) {
            histories.add(playRound());
        }
        return new Histories(histories);
    }

    private History playRound() {
        Map<RacingCar, Integer> history = new HashMap<>();
        for (RacingCar car : cars) {
            car.move(RandomNumber.createRandomNumber());
            history.put(car, car.getStep());
        }
        return new History(history);
    }


    public List<String> findWinners(int maxScore) {
        List<String> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            if (car.isWinner(maxScore)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int findMaxScore() {
        int maxScore = 0;
        for (RacingCar car : cars) {
            Math.max(maxScore, car.getStep());
        }
        return maxScore;
    }
}
