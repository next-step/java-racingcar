package racingcar;

import java.util.*;

import static java.util.Collections.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class RacingGame {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void roundStart(int randomNumber) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop(randomNumber);
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
