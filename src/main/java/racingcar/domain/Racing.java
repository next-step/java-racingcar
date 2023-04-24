package racingcar.domain;

import racingcar.dto.RandomValue;
import racingcar.util.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class Racing {

    private static final String SPLIT_PLAYER_DELIMITER = ",";

    public static List<Car> makeCars(String playerGroup) {
        return Arrays.stream(splitPlayers(playerGroup))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static String[] splitPlayers(String playerGroup) {
        return playerGroup.split(SPLIT_PLAYER_DELIMITER);
    }

    public static void runRacing(List<Car> carList, int tryNumber) {
        OutputView.resultIntro();
        for (int i = 0; i < tryNumber; i++) {
            runCarsForOneTurn(carList);
            OutputView.printInput("\n");
        }
    }

    private static void runCarsForOneTurn(List<Car> carList) {
        carList.stream().forEach(car -> {
            car.move(new RandomValue());
            OutputView.printCarTraceUntilNow(car);
        });
    }
}
