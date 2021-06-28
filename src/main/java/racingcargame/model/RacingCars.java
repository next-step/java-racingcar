package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final String BAR = "-";
    private List<RacingCar> cars;
    private RacingCarHistory history = new RacingCarHistory();

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public void playGame(int roundNumber) {
        for (int i = 0; i < roundNumber; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (RacingCar car : cars) {
            car.move(RandomNumber.createRandomNumber());
            history.addHistory(car.getName() + " : " + stackUpBars(car.getStep()));
        }
        history.addHistory("");
    }

    private String stackUpBars(int step) {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < step; i++) {
            bar.append(BAR);
        }
        return bar.toString();
    }

    private int findMaxScore() {
        int maxScore = 0;
        for (RacingCar car : cars) {
            Math.max(maxScore, car.getStep());
        }
        return maxScore;
    }

    public String findWinners() {
        List<String> winners = new ArrayList<>();
        for (RacingCar car : cars) {
            if (car.isWinner(findMaxScore())) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }
}
