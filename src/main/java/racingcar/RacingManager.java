package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    public static List<Car> makeCars(String playerGroup) {
        return Arrays.stream(splitPlayers(playerGroup))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] splitPlayers(String playerGroup) {
        return playerGroup.split(",");
    }

    public static List<String> extractWinnerNames(List<Car> playerList) {
        Integer maxDistance = recordMaxDistance(playerList);
        List<Car> winners = pickWinners(playerList, maxDistance);

        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private static Integer recordMaxDistance(List<Car> playerList) {
        Integer maxDistance = 0;
        for (Car car : playerList) {
            maxDistance = car.getLongerDistance(maxDistance);
        }
        return maxDistance;
    }

    private static List<Car> pickWinners(List<Car> playerList, int maxDistance) {
        return playerList.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .collect(Collectors.toList());
    }

}
