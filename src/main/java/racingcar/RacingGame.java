package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final int totalRound;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String[] carNames, int totalRound, RandomNumberGenerator randomNumberGenerator) {
        this.totalRound = totalRound;
        this.resultView = new ResultView();
        this.randomNumberGenerator = randomNumberGenerator;
        readyRacingCars(carNames);
    }

    private void readyRacingCars(String[] carNames) {
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
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
