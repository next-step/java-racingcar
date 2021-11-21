package carracing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;
    private int maximumDistance;

    public Winners(List<Car> cars) {
        maximumDistanced(cars);

        this.winners = cars.stream()
                .filter(car -> car.getPosition() == maximumDistance)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return this.winners;
    }

    public void maximumDistanced(List<Car> cars) {
        for (Car car : cars) {
            this.maximumDistance = Math.max(this.maximumDistance, car.getPosition());
        }
    }
}
