package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final int numOfCar;
    private final int numOfTries;
    private final List<MidScore> midScoreList;

    public RacingGame(int numOfCar, int numOfTries) {
        this.numOfCar = numOfCar;
        this.numOfTries = numOfTries;
        this.midScoreList = new ArrayList<>();
    }

    public List<MidScore> racingGame() {

        List<Car> racingCars = new ArrayList<>(Collections.nCopies(numOfCar, new Car(0)));

        for (int value = 1; value <= numOfTries; value++) {
            racingCars = new Racing(racingCars).doRacing();
            midScoreList.add(new MidScore(racingCars));
        }

        return midScoreList;
    }

}
