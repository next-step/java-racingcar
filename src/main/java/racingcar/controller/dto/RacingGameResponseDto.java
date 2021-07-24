package racingcar.controller.dto;

import racingcar.domain.Distance;
import racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResponseDto {

    private List<CarResponseDto> cars;
    private boolean finish;

    public RacingGameResponseDto(List<CarResponseDto> cars, boolean finish) {
        this.cars = cars;
        this.finish = finish;
    }

    public List<CarResponseDto> getCars() {
        return cars;
    }

    public boolean isFinish() {
        return finish;
    }

    public List<Name> winners() {
        int max = this.cars.stream()
                .map(CarResponseDto::getDistance)
                .mapToInt(Distance::getValue)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        return cars.stream()
                .filter(car -> car.getDistance().getValue() == max)
                .map(CarResponseDto::getName)
                .collect(Collectors.toList());
    }
}
