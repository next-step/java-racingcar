package racingcar;

import java.util.*;

import static java.util.Collections.*;
import static java.util.Comparator.*;

public class RacingGame {

    private int longestDistance;
    private List<RacingCar> racingCars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public RacingGame(String[] carNames) {
        readyRacingCars(carNames);
    }

    private void readyRacingCars(String[] carNames) {
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public void roundStart(RandomNumberGenerator randomNumberGenerator) {
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
    }

    private void isWinner(RacingCar racingCar) {
        if (racingCar.getDistance() == longestDistance) {
            winners.add(racingCar.getCarName());
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
