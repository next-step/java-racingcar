package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Referee {
    public static List<CarInformation> judgeWinners(Cars cars) {
        return judgeWinners(cars.getInformationOnCars());
    }

    private static List<CarInformation> judgeWinners(List<CarInformation> cars) {
        TreeMap<Position, List<CarInformation>> positionToCars = new TreeMap<>(Comparator.reverseOrder());

        for (CarInformation car : cars) {
            Position position = car.getPosition();
            List<CarInformation> carsInPosition = positionToCars.getOrDefault(position, new ArrayList<>());

            carsInPosition.add(car);
            positionToCars.put(position, carsInPosition);
        }

        Position firstPosition = positionToCars.firstKey();
        return positionToCars.get(firstPosition);
    }
}
