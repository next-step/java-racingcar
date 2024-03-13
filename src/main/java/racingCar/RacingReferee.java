package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingReferee {

    public static List<CarName> pickWinners(RacingCars cars) {
        int farthestLocation = cars.findFarthestLocation();
        return cars.findCars().stream()
            .filter((car)->car.findCurrentLocation() == farthestLocation)
            .map(RacingCar::findCarName)
            .collect(Collectors.toList());
    }

}
