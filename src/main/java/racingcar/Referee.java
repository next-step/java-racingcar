package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public int getFarthestPosition(List<Car> cars) {
        Collections.sort(cars, (o1, o2) -> o2.getPosition() - o1.getPosition());
        return cars.get(0).getPosition();
    }

    public List<Car> getWinners(List<Car> cars) {
        int farthestPosition = getFarthestPosition(cars);
        return cars.stream().filter(car -> car.getPosition() == farthestPosition).collect(Collectors.toList());
    }
}
