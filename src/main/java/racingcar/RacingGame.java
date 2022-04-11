package racingcar;

import java.util.*;

import static java.util.Collections.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class RacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(String[] carNames) {
        readyRacingCars(carNames);
    }

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
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

    public List<String> winnersOfTheRace() {
        int longestDistance = findLongestDistance();
        return racingCars.stream()
                .filter(racingCar -> racingCar.getDistance() == longestDistance)
                .map(RacingCar::getCarName)
                .collect(toList());
    }

    private int findLongestDistance() {
        return max(racingCars, comparing(RacingCar::getDistance))
                .getDistance();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
