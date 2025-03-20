package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultRacingCarGameWinnerStrategy implements RacingCarGameWinnerStrategy {
    @Override
    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            return Collections.emptyList();
        }

        List<RacingCar> result = new ArrayList<>();
        racingCars = RacingCar.toSortedRacingCars(racingCars);
        RacingCar winner = racingCars.get(0);

        for (RacingCar car : racingCars) {
            if (winner.compareTo(car) < 0) {
                break;
            }
            result.add(car);
        }
        return result;
    }
}
