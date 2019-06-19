package racinggame;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    public static final int MIN_CAR_QUANTITY = 1;
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        int carQuantity = carNames.getCarNameList().size();
        Preconditions.checkArgument(carQuantity >= MIN_CAR_QUANTITY, "자동차 숫자는 1 이상이어야 합니다.");

        List<Car> carList = new ArrayList<>();
        carNames.getCarNameList().forEach((carName) -> carList.add(new Car(carName)));
        this.cars = carList;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, Integer> getPositions() {
        Map<String, Integer> positions = new LinkedHashMap<>();
        for (Car car : cars) {
            positions.put(car.getCarName(), car.getPosition());
        }
        return positions;
    }
}
