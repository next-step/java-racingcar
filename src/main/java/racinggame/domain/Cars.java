package racinggame.domain;

import com.google.common.base.Preconditions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Cars {
    public static final int MIN_CAR_QUANTITY = 1;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(CarNames carNames) {
        int carQuantity = carNames.getSize();
        Preconditions.checkArgument(carQuantity >= MIN_CAR_QUANTITY, "자동차 숫자는 1 이상이어야 합니다.");

        this.cars = carNames.getCarNameList()
                .stream()
                .map(Car::new)
                .collect(toList());
    }

    public Map<String, Integer> getPositions() {
        Map<String, Integer> positions = new LinkedHashMap<>();
        for (Car car : cars) {
            positions.putAll(car.getCarMap());
        }
        return positions;
    }

    public Cars moveCarsByDecider(MoveDecider moveDecider) {
        return new Cars(cars.stream()
                .map(car -> moveCar(car, moveDecider.canMove()))
                .collect(Collectors.toList()));
    }

    private Car moveCar(Car car, boolean canMove) {
        if (canMove) {
            car = car.move();
        }
        return car;
    }
}
