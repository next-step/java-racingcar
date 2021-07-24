package racingcar.controller.dto;

import java.util.List;

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
}
