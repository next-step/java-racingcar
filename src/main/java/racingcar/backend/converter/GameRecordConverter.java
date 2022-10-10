package racingcar.backend.converter;

import racingcar.backend.domain.Cars;
import racingcar.backend.dto.CarDto;
import racingcar.backend.domain.GameRecord;

import java.util.List;
import java.util.stream.Collectors;

public class GameRecordConverter {

    public static GameRecord getGameRecord(Cars cars) {
        List<CarDto> carDtos = cars.getValues().stream()
                .map(car -> CarDto.create(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
        return new GameRecord(carDtos);
    }
}
