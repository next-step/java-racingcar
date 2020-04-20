package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> allCars;

    public Winner(List<Car> allCars) {
        this.allCars = new ArrayList<>(allCars);
    }

    private int maxPosition() {
        int maxPosition = 0;
        for (Car car : allCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> findWinnerNames() {
        int maxPosition = maxPosition();

        return allCars.stream()
                .filter(x -> x.isInPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
