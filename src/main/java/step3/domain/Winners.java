package step3.domain;

import java.util.*;

public class Winners {

    public static final String WINNERS_COMMA_DELIMITER = ", ";
    private static List<String> winners;

    public static String findWinner(Map<String, Car> carInfoMap, int maxPosition) {
        winners = new ArrayList<>();

        for (String carName : carInfoMap.keySet()) {
            Car car = carInfoMap.get(carName);
            verifyWinner(winners, car, maxPosition);
        }
        return String.join(WINNERS_COMMA_DELIMITER, winners);
    }

    public static List<String> verifyWinner(List<String> winnerNames, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winnerNames.add(car.getCarName());
        }
        return winnerNames;
    }
}
