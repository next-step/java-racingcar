package racing.models;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private final List<Car> carList;

    public Round(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getLeaderList() {
        final int maxDistance = getMaxDistance();

        return carList.stream()
                .filter(e -> e.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return carList.stream().map(Car::getDistance).max(Integer::compare).orElse(-1);
    }
}
