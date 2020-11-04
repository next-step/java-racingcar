package step3.domain;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RacingMap {
    private final Map<RacingCar, Integer> racingCarLocation;

    public RacingMap(final List<RacingCar> racingCars) {
        this.racingCarLocation = racingCars.stream()
                .collect(Collectors.toMap(Function.identity(), RacingCar::getStartPosition));
    }

    private RacingMap(final Map<RacingCar, Integer> racingCarLocation) {
        this.racingCarLocation = racingCarLocation;
    }

    public void move(final RacingCar racingCar, final int unitOfForward) {
        racingCarLocation.computeIfPresent(racingCar, (car, position) -> position + unitOfForward);
    }

    public RacingMap clone() {
        return new RacingMap(Collections.unmodifiableMap(new HashMap<>(racingCarLocation)));
    }

    public int findPosition(final RacingCar racingCar) {
        return racingCarLocation.get(racingCar);
    }

    public List<String> selectWinnerNames() {
        final int farthestLocation = Collections.max(racingCarLocation.values());
        final List<String> winnerNames = new ArrayList<>();
        for (final RacingCar car : racingCarLocation.keySet()) {
            if (racingCarLocation.get(car) == farthestLocation) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
