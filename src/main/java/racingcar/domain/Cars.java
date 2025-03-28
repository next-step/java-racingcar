package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;

public class Cars {

    private static final int MIN_QUANTITY = 0;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNonNegativity(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars ofQuantity(final int quantity) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    private static void validateNonNegativity(final List<Car> cars) {
        if (cars.size() == MIN_QUANTITY) {
            throw new IllegalArgumentException("자동차 수는 음수이면 안됩니다");
        }
    }

    public void move(final Movement movement) {
        cars.forEach(car -> car.move(movement.canMove()));
    }

    public List<CarDto> getCarsInfo() {
        return cars.stream()
                .map(Car::toDto).collect(Collectors.toList());
    }
}
