package racingcar.domain;

import java.util.*;

public class Winner {

    public Names who(Cars cars) {
        Distance maxDistance = cars.findMaxDistance();
        return findNames(cars, maxDistance);
    }

    private Names findNames(Cars cars, Distance maxDistance) {
        Map<Distance, Names> distanceNamesMap = new HashMap<>();
        for (Car car : cars.get()) {
             putToMap(distanceNamesMap, car);
        }

        return distanceNamesMap.get(maxDistance);
    }

    private void putToMap(Map<Distance, Names> distanceNamesMap, Car car) {
        Distance carDistance = car.getDistance();
        Name carName = car.getName();
        if (distanceNamesMap.containsKey(carDistance)) {
            distanceNamesMap.get(carDistance).add(carName);
            return;
        }

        Names names = new Names();
        names.add(carName);
        distanceNamesMap.put(carDistance, names);
    }
}
