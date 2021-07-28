package racingcar.controller.dto;

import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class RacingGameResponseDto {

    private Cars cars;
    private boolean finish;

    public RacingGameResponseDto(Cars cars, boolean finish) {
        this.cars = cars;
        this.finish = finish;
    }

    public Winners winners() {
        return cars.getWinners();
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isFinish() {
        return finish;
    }
}
