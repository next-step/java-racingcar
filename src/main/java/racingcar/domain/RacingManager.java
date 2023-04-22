package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    private static final String SPLIT_PLAYER_DELIMITER = ",";

    public static List<Car> makeCars(String playerGroup) {
        return Arrays.stream(splitPlayers(playerGroup))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] splitPlayers(String playerGroup) {
        return playerGroup.split(SPLIT_PLAYER_DELIMITER);
    }

    public static List<String> extractWinnerNames(List<Car> playerList) {
        int distanceMax = recordDistanceMax(playerList);
        List<Car> winners = pickWinners(playerList, distanceMax);

        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static int recordDistanceMax(List<Car> playerList) {
        int distanceMax = 0;
        for (Car car : playerList) {
            distanceMax = car.chooseLongerDistance(distanceMax); // todo
        }
        return distanceMax;
    }

    private static List<Car> pickWinners(List<Car> playerList, int distanceMax) {
        return playerList.stream()
                .filter(car -> car.isSameDistance(distanceMax))
                .collect(Collectors.toList());
    }

}
