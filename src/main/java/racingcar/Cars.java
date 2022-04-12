package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> cars;

    public Cars(List<Car> input) {
        validate(input);
        List<Car> cars = new ArrayList<>(input);
        this.cars = cars;
    }

    private void validate(List<Car> input) {
        Objects.requireNonNull(input, "전달된 리스트가 올바르지 않습니다 : Cars is null");

        if (input.isEmpty()) {
            throw new IllegalArgumentException("전달된 리스트가 올바르지 않습니다 : Cars is empty");
        }
    }

    public Cars play(MovingStrategy movingStrategy) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            Car newCar = car.move(movingStrategy);
            PositiveInteger newState = PositiveInteger.add(car.state(), newCar.state());
            result.add(new Car(newState));
        }
        return new Cars(result);
    }

    public List<PositiveInteger> states() {
        return cars.stream()
                .map(Car::state)
                .collect(Collectors.toList());
    }
}
