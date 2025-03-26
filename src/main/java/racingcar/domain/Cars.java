package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars ofQuantity(final int quantity) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public void move(final Movement movement) {
        cars.forEach(car -> car.move(movement.canMove()));
    }

}
