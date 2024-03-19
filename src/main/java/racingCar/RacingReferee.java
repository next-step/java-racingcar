package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingReferee {

    public static int findFarthestLocation(RacingCars cars) {
        int maxDistance = 0;
        for (RacingCar car : cars.findCars()) {
            maxDistance = car.compareMaxDistance(maxDistance);
        }
        return maxDistance;
    }

    public static List<String> pickWinners(RacingCars cars) {
        int farthestLocation = findFarthestLocation(cars);
        return cars.findCars().stream()
            .filter((car) -> car.isSameLocation(farthestLocation))
            .map(RacingCar::findCarName)
            .collect(Collectors.toList());
    }

}
