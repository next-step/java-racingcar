package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    /**
     * 우승자를 찾습니다.
     * @param cars
     * @return
     */
    public static List<Car> findWinners(List<Car> cars) {
        int maxScore = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        return cars.stream().filter(car -> car.getPosition() == maxScore).collect(Collectors.toList());
    }
}
