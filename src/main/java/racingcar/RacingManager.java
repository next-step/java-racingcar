package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingManager {

    public static List<Car> makeCars(String playerGroup) {
        return Arrays.stream(splitPlayers(playerGroup))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] splitPlayers(String playerGroup) {
        return playerGroup.split(",");
    }
}
