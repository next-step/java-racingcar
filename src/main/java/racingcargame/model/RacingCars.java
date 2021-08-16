package racingcargame.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {
    private final List<RacingCar> cars;
    private final MoveStrategy moveStrategy = new MoveStrategy();

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public History playRound() {
        Map<RacingCar, Integer> history = new HashMap<>();

        for (RacingCar car : cars) {
            car.move(moveStrategy.isMovable(RandomNumber.createRandomNumber()));
            car.recordHistory(history);
        }
        return new History(history);
    }

    public List<String> findWinners() {
        int maxScore = findMaxScore();
        List<String> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            if (car.isWinner(maxScore)) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int findMaxScore() {
        int maxScore = 0;
        for (RacingCar car : cars) {
            Math.max(maxScore, car.getStep());
        }
        return maxScore;
    }
}
