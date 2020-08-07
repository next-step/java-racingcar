package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRound {
    private List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> cars) {
        this.racingCars = cars.stream().map(RacingCar::clone).collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> findBestScoreCars() {
        int bestScore = racingCars.stream()
                .map(RacingCar::getCarPosition)
                .max(Integer::compareTo)
                .get();

        return racingCars.stream()
                .filter(car -> car.getCarPosition() == bestScore)
                .collect(Collectors.toList());
    }
}
