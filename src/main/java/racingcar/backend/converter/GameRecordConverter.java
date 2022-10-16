package racingcar.backend.converter;

import racingcar.backend.domain.Cars;
import racingcar.backend.dto.CarDto;
import racingcar.backend.domain.GameRecord;


import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class GameRecordConverter {

    public static GameRecord getGameRecord(Cars cars) {
        return cars.getValues().stream()
                .map(car -> CarDto.create(car.getName(), car.getPosition()))
                .collect(collectingAndThen(toList(), GameRecord::new));
    }
}
