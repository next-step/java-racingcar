package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Judgement {

    public List<Car> getWinnerCars(List<Car> cars) {

        int maxDistance = cars.stream()
                                .mapToInt(Car::getDistance)
                                .max()
                                .orElse(0);

        return cars.stream()
                    .filter(io-> io.getDistance() == maxDistance)
                    .collect(Collectors.toList());
    }
}
