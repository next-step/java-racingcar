package step3.domain;

import step3.domain.history.CarHistory;
import step3.service.IntNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    private Cars() {
    }

    private Cars(List<Car> carList) {
        validateIsEmpty(carList);
        this.carList = carList;
    }

    public static Cars join(List<Car> cars) {
        return new Cars(cars);
    }

    public List<CarHistory> move(IntNumberGenerator generator) {
        List<CarHistory> carHistoryList = new ArrayList<>();
        for (Car car : carList) {
            carHistoryList.add(car.move(generator));
        }
        return carHistoryList;
    }

    private void validateIsEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
