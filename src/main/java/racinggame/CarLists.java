package racinggame;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class CarLists {
    public static final int MIN_CAR_QUANTITY = 1;
    private final List<Car> carList;

    public CarLists(int carQuantity) {
        Preconditions.checkArgument(carQuantity >= MIN_CAR_QUANTITY, "자동차 숫자는 1 이상이어야 합니다.");
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carQuantity; i++) {
            carList.add(new Car());
        }
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
