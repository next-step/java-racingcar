package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Racing {
    private final CarGroup carGroup;

    public Racing(CarGroup carGroup) {
        this.carGroup = carGroup;
    }

    private static final String SPLIT_PLAYER_DELIMITER = ",";

    public static List<Car> makeCars(String playerGroup) {
        return Arrays.stream(splitPlayers(playerGroup))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] splitPlayers(String playerGroup) {
        return playerGroup.split(SPLIT_PLAYER_DELIMITER);
    }

    public CarGroup runRacing(){
        carGroup.moveAll(new RandomValue());
        return carGroup;
    }

}
