package step3.domain;

import java.util.*;

public class Winners {



    private static List<String> winners;

    public static List<String> findWinners(Map<String, Car> carInfoMap, int maxPosition) {
        winners = new ArrayList<>();

        for (String carName : carInfoMap.keySet()) {
            Car car = carInfoMap.get(carName);
            verifyWinner(winners, car, maxPosition);
        }
        return winners;
    }

    public static List<String> verifyWinner(List<String> winnerNames, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winnerNames.add(car.getCarName());
        }
        return winnerNames;
    }
}
