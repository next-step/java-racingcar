package racinggame;

import com.google.common.base.Preconditions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class Cars {
    public static final int MIN_CAR_QUANTITY = 1;
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        int carQuantity = carNames.getSize();
        Preconditions.checkArgument(carQuantity >= MIN_CAR_QUANTITY, "자동차 숫자는 1 이상이어야 합니다.");

        this.cars = carNames.getCarNameList()
                .stream()
                .map(Car::new)
                .collect(toList());
    }

    public void moveCarsByRandomCondition() {
        cars.forEach(CarHandler::moveCarByRandomCondition);
    }

    public Map<String, Integer> getPositions() {
        Map<String, Integer> positions = new LinkedHashMap<>();
        for (Car car : cars) {
            positions.put(car.getCarName(), car.getPosition());
        }
        return positions;
    }
}
