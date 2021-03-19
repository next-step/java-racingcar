package step4.domain.racing;

import step4.domain.car.Car;
import step4.domain.ipnut.InputNames;
import step4.startegy.Move;

import java.util.List;
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

    public List<Car> winners(int winnerPosition) {
        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }

    public final int maxPosition() {
        return cars.stream()
                .mapToInt(car -> car.position().position())
                .max()
                .orElseGet(() -> 0);
    }
}
