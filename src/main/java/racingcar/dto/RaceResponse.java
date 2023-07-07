package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.CarVO;

import java.util.List;

public final class RaceResponse {

    private final List<CarVO> cars;

    public RaceResponse(final List<Car> cars) {
        this.cars = CarVO.toList(cars);
    }

    public List<CarVO> getCars() {
        return cars;
    }
}
