package carRacing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WinnersName {
    private final List<String> winnersName = new ArrayList<>();

    public List<String> findWinner(List<RacingCar> racingCars){
        int highScore = findRecords(racingCars);
        for (RacingCar car: racingCars) {
            this.winnersName.add(findWinnersName(highScore,car));
        }
        this.winnersName.removeAll(Collections.singletonList("no Winner"));
        return this.winnersName;
    }

    private int findRecords(List<RacingCar> racingCars){
        List<Integer> score = new LinkedList<>();
        for (RacingCar car: racingCars) {
            score.add(car.position());
        }
        return Collections.max(score);
    }

    private String findWinnersName(int highScore, RacingCar car){
        if (highScore == car.position()) {
            return car.name();
        }
        return "no Winner";
    }
}
