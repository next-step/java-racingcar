package racingcar.car;

import racingcar.common.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarManager {
    private final List<Car> cars;
    private final int repeat;

    public CarManager(int count, int repeat) {
        this.cars = IntStream.range(0, count)
                .boxed()
                .map(i -> new Car())
                .collect(Collectors.toList());
        this.repeat = repeat;
    }

    public void startRace() {
        System.out.println("실행 결과");
        IntStream.range(0, repeat)
                .boxed()
                .peek(this::moveCars)
                .forEach(this::drawingCars);
    }

    protected void moveCars(int index) {
        cars.forEach(car -> car.move(RandomUtils.getNextInt()));
    }

    protected void drawingCars(int index) {
        cars.forEach(car -> System.out.println(car.getPosition()));
        System.out.println();
    }
}
