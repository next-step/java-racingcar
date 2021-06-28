package racingcargame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private static final String BAR = "-";
    private List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public RacingCarHistory playGame(int roundNumber) {
        List<String> history = new ArrayList<>();
        for (int i = 0; i < roundNumber; i++) {
            history.add(playRound());
        }
        return new RacingCarHistory(history);
    }

    private String playRound() {
        List<String> history = new ArrayList<>();
        for (RacingCar car : cars) {
            car.move(RandomNumber.createRandomNumber());
            history.add(car.getName() + " : " + stackUpBars(car.getStep()));
        }
        history.add("");
        return String.join("\n", history);
    }

    private String stackUpBars(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append(BAR);
        }
        return bar.toString();
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

    public int findMaxScore() {
        int maxScore = 0;
        for (RacingCar car : cars) {
            Math.max(maxScore, car.getStep());
        }
        return maxScore;
    }
}
