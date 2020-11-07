package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class SelectFarthestDistanceWinnerStrategy implements SelectWinnerStrategy{
    @Override
    public List<RacingCar> select(final List<RacingCar> racingCars) {
        final int farthestDistance = findFarthestDistance(racingCars);
        return racingCars.stream()
                .filter(car -> car.isPositionEqual(farthestDistance))
                .collect(Collectors.toList());
    }

    private int findFarthestDistance(final List<RacingCar> racingCars) {
        return racingCars.stream()
                .map(RacingCar::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
