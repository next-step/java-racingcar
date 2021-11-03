package racingcar.service.dto;

import racingcar.service.domain.Car;
import racingcar.utils.Preconditions;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 일급 컬렉션
 */
public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        Preconditions.checkNotNull(carList, "carList required not null");

        this.carList = carList;
    }

    public static Cars from(List<Car> carList) {
        return new Cars(carList);
    }

    public List<Integer> getPositions() {
        return carList.stream().map(Car::getPosition).collect(Collectors.toList());
    }
}

