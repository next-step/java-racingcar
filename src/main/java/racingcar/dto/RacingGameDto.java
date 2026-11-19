package racingcar.dto;

import racingcar.domain.Cars;

import java.util.List;

public class RacingGameDto {

    private final List<CarDto> result;

    private RacingGameDto(Cars cars) {
        this.result = cars.getCars()
                .stream()
                .map(CarDto::from)
                .toList();
    }

    public static RacingGameDto from(Cars cars) {
        return new RacingGameDto(cars);
    }

    public List<CarDto> getResult() {
        return result;
    }

}
