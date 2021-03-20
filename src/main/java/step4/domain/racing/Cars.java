package step4.domain.racing;

import step4.domain.car.Car;
import step4.domain.car.position.Position;
import step4.domain.ipnut.InputNames;
import step4.startegy.Move;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    public Cars(String s) {
        this(new InputNames(s));
    }

    public Cars(InputNames inputNames) {
        this(inputNames.inputNames().stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public Cars(List<Car> cars) {
        if (isNull(cars)) {
            throw new IllegalArgumentException("유효하지 않은 값을 사용했습니다.");
        }
        this.cars = cars;
    }

    private final boolean isNull(List<Car> cars) {
        return cars == null;
    }

    public final void move(Move move) {
        cars.stream().forEach(car -> car.move(move));
    }

    public final List<Car> cars() {
        return cars;
    }

    public final List<Car> winners(Position winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }

    public final Position maxPosition() {
        return cars.stream()
                .map(car -> car.position())
                .reduce(Position::winningPosition).get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
