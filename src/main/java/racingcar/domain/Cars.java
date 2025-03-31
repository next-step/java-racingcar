package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;

public class Cars {

    private static final int MIN_QUANTITY = 0;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNonNegativity(cars);
        validateDuplicated(cars);
        this.cars = new ArrayList<>(cars);
    }

    public static Cars ofNames(final List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new).collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validateNonNegativity(final List<Car> cars) {
        if (cars.size() == MIN_QUANTITY) {
            throw new IllegalArgumentException("자동차를 최소 1대이상 생성해야합니다.");
        }
    }

    public void move(final Movement movement) {
        cars.forEach(car -> car.move(movement.move()));
    }

    public List<CarDto> getCarsInfo() {
        return cars.stream().map(CarDto::toDto)
                .collect(Collectors.toList());
    }

    private void validateDuplicated(List<Car> cars) {
        if (cars.size() > new HashSet<>(cars).size()) {
            throw new IllegalArgumentException("자동차는 중복될 수 없습니다.");
        }
    }

}
