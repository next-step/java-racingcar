package racingcar.dto;

import racingcar.domain.Cars;

import java.util.Collections;
import java.util.List;

public class RacingCarResponseDto {
    private final List<Cars> cars;
    private final Cars winners;

    public RacingCarResponseDto(List<Cars> cars, Cars winners) {
        this.cars = Collections.unmodifiableList(cars);
        this.winners = winners;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public Cars getWinners() {
        return winners;
    }
}
