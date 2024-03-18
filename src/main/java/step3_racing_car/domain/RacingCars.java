package step3_racing_car.domain;

import step3_racing_car.strategy.MovingStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> items;

    public RacingCars(List<RacingCar> items) {
        this.items = items;
    }

    public void movePosition(MovingStrategy movingStrategy) {
        for (RacingCar item : items) {
            item.movePositions(movingStrategy.move());
        }
    }

    public RacingCars matchPositionList(int maxPosition) {
        return new RacingCars(this.items.stream()
                .filter(car -> car.isMatch(maxPosition))
                .collect(Collectors.toList()));
    }

    public int maxPositionValue() {
        int maxPosition = 0;
        for (RacingCar car : this.items) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public List<RacingCar> getItems() {
        return items;
    }

    public List<String> getNames() {
        return items.stream()
                .map(RacingCar::getName)
                .map(Name::toString)
                .collect(Collectors.toList());
    }
}
