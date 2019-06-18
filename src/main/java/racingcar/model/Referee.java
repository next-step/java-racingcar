package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Referee {
    public static List<CarInformation> judgeWinners(Cars cars) {
        return judgeWinners(cars.getCarInformationList());
    }

    private static List<CarInformation> judgeWinners(List<CarInformation> cars) {
        TreeMap<Position, List<CarInformation>> informationMap = new TreeMap<>();

        for (CarInformation car : cars) {
            Position position = car.getPosition();
            List<CarInformation> carListInMap = informationMap.getOrDefault(position, null);
            if (carListInMap == null) {
                carListInMap = new ArrayList<>();
            }
            carListInMap.add(car);
            informationMap.put(position, carListInMap);
        }

        Position firstPosition = informationMap.lastKey();
        return informationMap.get(firstPosition);
    }
}
