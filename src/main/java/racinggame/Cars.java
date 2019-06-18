package racinggame;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int MIN_CAR_QUANTITY = 1;
    private final List<Car> cars;

    public Cars(int carQuantity) {
        Preconditions.checkArgument(carQuantity >= MIN_CAR_QUANTITY, "자동차 숫자는 1 이상이어야 합니다.");
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            carList.add(new Car());
        }
        this.cars = carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
