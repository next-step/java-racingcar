package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Referee {
    public static List<CarInformation> judgeWinners(Cars cars) {
        TreeMap<Position, List<CarInformation>> positionToCars = makeTreeMap(cars);
        Position firstPosition = positionToCars.firstKey();
        return positionToCars.get(firstPosition);
    }

    private static TreeMap<Position, List<CarInformation>> makeTreeMap(Cars cars) {
        List<CarInformation> informationOnCars = cars.getInformationOnCars();
        TreeMap<Position, List<CarInformation>> positionToCars = new TreeMap<>(Comparator.reverseOrder());

        for (CarInformation car : informationOnCars) {
            Position position = car.getPosition();
            List<CarInformation> carsInPosition = positionToCars.getOrDefault(position, new ArrayList<>());

            carsInPosition.add(car);
            positionToCars.put(position, carsInPosition);
        }
        return positionToCars;
    }
}
