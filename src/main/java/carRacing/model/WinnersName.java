package carRacing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WinnersName {
    private final List<String> winnersName = new ArrayList<>();

    public List<String> findWinner(List<RacingCar> racingCars){
        int highScore = maxScore(racingCars);
        for (RacingCar car : racingCars) addWinnerName(car, highScore);
        return this.winnersName;
    }

    private int maxScore(List<RacingCar> racingCars){
        List<Integer> score = new LinkedList<>();
        for (RacingCar car: racingCars) score.add(car.position());
        return Collections.max(score);
    }

    private void addWinnerName(RacingCar car, int highScore) {
        if (car.isSamePosition(highScore)) this.winnersName.add(car.name());
    }
}
