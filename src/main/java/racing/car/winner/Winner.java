package racing.car.winner;

import racing.car.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public static List<String> getWinnerInfo(int max, List<Car> cars) {
        return cars.stream().filter(car -> car.isSame(max))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
