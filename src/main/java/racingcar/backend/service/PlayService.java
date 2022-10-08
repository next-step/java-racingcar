package racingcar.backend.service;

import racingcar.backend.domain.*;
import racingcar.backend.strategy.MoveStrategy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayService {

    public static Cars playCar(Cars cars, MoveStrategy moveStrategy) {
        for (Car car : cars.getValues()) {
            car.move(moveStrategy);
        }
        return cars;
    }

    public static GameRecord getGameRecord(Cars cars) {
        Map<CarName, Position> record = cars.getValues().stream()
                .collect(Collectors.toMap(
                        car -> new CarName(car.getName()),
                        car -> new Position(car.getPosition()),
                        (u, v) -> v,
                        LinkedHashMap::new));
        return GameRecord.create(record);
    }
}
