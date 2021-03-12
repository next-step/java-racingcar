package racingcar.domain.racing;

import racingcar.domain.car.Car;
import racingcar.domain.car.RandomMoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private static final int ZERO = 0;

    private List<Car> cars;

    public static RacingCars from(int amount) {
        return new RacingCars(amount);
    }

    private RacingCars(int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException("0 이하의 숫자로 자동차를 생성할 수 없습니다.");
        }
        cars = generateCars(amount);
    }

    private List<Car> generateCars(int amount) {
        return IntStream.range(ZERO, amount)
                .mapToObj((int value) -> new Car())
                .collect(Collectors.toList());
    }

    public List<Car> move() {
        return cars.stream().peek(car ->
                car.move(RandomMoveStrategy.getInstance())).map(Car::new).collect(Collectors.toList());
    }

}
