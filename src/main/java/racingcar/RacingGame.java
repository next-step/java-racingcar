package racingcar;

import java.util.*;

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
                .filter(racingCar -> racingCar.isWinner(longestDistance))
                .map(RacingCar::getCarName)
                .collect(toList());
    }

    private int findLongestDistance() {
        int longestDistance = 0;
        for (RacingCar racingCar : racingCars) {
            longestDistance = racingCar.findLongestDistance(longestDistance);
        }
        return longestDistance;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}
