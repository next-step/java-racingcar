package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.CarVO;

import java.util.List;

public class RaceResponse {

    private final List<CarVO> cars;

    public RaceResponse(List<Car> cars) {
        this.cars = CarVO.toList(cars);
    }

    public List<CarVO> getCars() {
        return cars;
    }
}
