package step3.domain;

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

    public static Cars join(List<Car> carList) {
        return new Cars(carList);
    }

    public Cars move(IntNumberGenerator generator) {
        List<Car> copyList = new ArrayList<>();
        for (Car car : carList) {
            copyList.add(car.move(generator));
        }
        return Cars.join(copyList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    private void validateIsEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참여할 자동차가 존재하지 않습니다.");
        }
    }
}
