package racingcar;

import java.util.*;

import static java.util.Collections.*;
import static java.util.Comparator.*;

public class RacingGame {

    private int totalRound;
    private int longestDistance;
    private ResultView resultView;
    private RandomNumberGenerator randomNumberGenerator;
    private List<RacingCar> racingCars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

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
        findLongestDistance();
    }

    private void roundStart() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop(randomNumberGenerator.generateRacingRandomNumber());
        }
    }

    private void findLongestDistance() {
        longestDistance = max(racingCars, comparing(RacingCar::getDistance))
                .getDistance();
    }

    public void winnersOfTheRace() {
        for (RacingCar racingCar : racingCars) {
            isWinner(racingCar);
        }
        resultView.winnerLogTrace(winners);
    }

    private void isWinner(RacingCar racingCar) {
        if (racingCar.getDistance() == longestDistance) {
            winners.add(racingCar.getCarName());
        }
    }
}
