package racingCar.findWinners;

import racingCar.RacingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NameOfWinners {
    List<String> nameOfWinner = new ArrayList<>();

    public List<String> findWinner(List<RacingCar> racingCars){
        int highScore = findRecordsOfWinner(racingCars);
        for (RacingCar car: racingCars) {
            this.nameOfWinner.add(findNameOfWinner(highScore,car));
        }
        this.nameOfWinner.removeAll(Collections.singletonList("notWinner"));
        return this.nameOfWinner;
    }

    private int findRecordsOfWinner(List<RacingCar> racingCars){
        List<Integer> score = new LinkedList<Integer>();
        for (RacingCar car: racingCars) {
            score.add(car.positionOfRacingCar());
        }
        return Collections.max(score);
    }

    private String findNameOfWinner(int highScore, RacingCar car){
        if (highScore == car.positionOfRacingCar()) {
            return car.NameOfCar();
        }
        return "notWinner";
    }

}


