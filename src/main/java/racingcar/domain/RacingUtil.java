package racingcar.domain;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingUtil {

    public static String getJoiningName(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(","));
    }
}
