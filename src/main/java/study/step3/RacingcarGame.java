package study.step3;

import java.util.*;

import static study.step3.InputView.numberOfAttempt;
import static study.step3.InputView.numberOfCar;

public class RacingcarGame {
    private List<Racingcar> racingcarList = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();

    public RacingcarGame() {
        createRacingcar();
    }

    private void createRacingcar() {
        for(int i = 0; i < numberOfCar; i++) {
            racingcarList.add(new Racingcar());
        }
    }

    public void startRacingcarGame() {
        for (int i = 1; i <= numberOfAttempt; i++) {
            for (Racingcar car : racingcarList) {
                car.tryToMoveForward();
                resultList.add(car.getPosition());
            }
            resultList.add(-1);
        }
    }
}
