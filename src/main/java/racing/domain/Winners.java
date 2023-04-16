package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {
    private final List<RacingCar> winners;

    public Winners(List<RacingCar> cars) {
        this.winners = new ArrayList<>();
        Position maxPosition = getMaxPosition(cars);
        findWinners(cars, maxPosition);
    }

    private static Position getMaxPosition(List<RacingCar> cars) {
        List<Position> positions = cars.stream()
                .map(RacingCar::position)
                .collect(Collectors.toList());

        return Collections.max(positions);
    }

    private void findWinners(List<RacingCar> cars, Position maxPosition) {
        for (RacingCar car : cars) {
            addWinner(maxPosition, car);
        }
    }

    private void addWinner(Position maxPosition, RacingCar car) {
        if (Objects.equals(car.position(), maxPosition)) {
            winners.add(car);
        }
    }

    public int size() {
        return winners.size();
    }

    public RacingCar get(int index) {
        return winners.get(index);
    }
}