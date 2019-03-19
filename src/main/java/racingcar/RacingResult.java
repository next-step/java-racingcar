package racingcar;

import racingcar.utils.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResult {
    List<RacingCar> racingCars;

    public RacingResult(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public String createDisplayWinnerNames() {
        List<RacingCar> winners = findWinners();
        return joinComma(getWinnerNames(winners));
    }

    private static String joinComma(List<String> winnerNames) {
        return String.join(Constant.FORMAT_COMMA, winnerNames);
    }

    public List<RacingCar> findWinners() {
        int maxCoordinate = maxCoordinate();
        return getWinners(maxCoordinate);
    }

    private int maxCoordinate() {
        int maxcoordinate = 0;
        for (RacingCar car: racingCars) {
            maxcoordinate = car.findMaxCoordinate(maxcoordinate);
        }
        return maxcoordinate;
    }

    private List<RacingCar> getWinners(int maxCoordinate) {
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar car: racingCars) {
            if (car.isMaxCoordinate(maxCoordinate)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static List<String> getWinnerNames(List<RacingCar> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (RacingCar car: winners) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}
