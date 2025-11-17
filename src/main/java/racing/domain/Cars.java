package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final int carCount;
    private final List<Car> cars;

    public Cars(int carCount) {
        validateCount(carCount);
        this.carCount = carCount;
        this.cars = createCars();
    }

    private void validateCount(int carCount) {
        if (carCount == 1) {
            throw new RuntimeException("자동차 경주를 진행하기 위해서는 두 대 이상의 자동차가 필요합니다.");
        }
    }

    private List<Car> createCars() {
        List<Car> created = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            created.add(new Car());
        }
        return created;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public int size() {
        return cars.size();
    }
}
