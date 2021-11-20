package carracing.util;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(List<Car> cars, RaceResult raceResult) {
        this.winners = cars.stream()
                .filter(car -> car.getDrivingHistory() == raceResult.maximumDistance)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return this.winners;
    }
}
