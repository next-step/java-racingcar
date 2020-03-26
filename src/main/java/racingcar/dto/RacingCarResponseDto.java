package racingcar.dto;

import racingcar.domain.Cars;
import racingcar.domain.car.Car;

import java.util.Collections;
import java.util.List;

public class RacingCarResponseDto {
    private final List<Cars> cars;
    private final List<Car> winners;

    public RacingCarResponseDto(List<Cars> cars, List<Car> winners) {
        this.cars = Collections.unmodifiableList(cars);
        this.winners = Collections.unmodifiableList(winners);
    }

    public List<Cars> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
