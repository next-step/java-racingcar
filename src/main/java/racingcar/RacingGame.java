package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int totalRound;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(int racingCarCount, int totalRound, RandomNumberGenerator randomNumberGenerator) {
        this.totalRound = totalRound;
        this.resultView = new ResultView();
        this.randomNumberGenerator = randomNumberGenerator;
        readyRacingCars(racingCarCount);
    }

    private void readyRacingCars(int racingCarCount) {
        for (int i = 0; i < racingCarCount; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public void raceStart() {
        for (int i = 0; i < totalRound; i++) {
            roundStart();
            resultView.roundLogTrace(racingCars);
        }
    }

    private void roundStart() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop(randomNumberGenerator.generateRacingRandomNumber());
        }
    }
}
