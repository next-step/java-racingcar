package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    static List<Car> findWinner(Cars cars) {
        List<Car> carList = cars.getCars();
        int maxDistance = getMaxDistance(carList);

        return carList.stream().filter(car -> car.matchDistance(maxDistance)).collect(Collectors.toList());
    }

    static int getMaxDistance(List<Car> carList) {
        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = car.max(maxDistance);
        }

        return maxDistance;
    }

}
