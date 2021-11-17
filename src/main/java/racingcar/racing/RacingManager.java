package racingcar.racing;

import racingcar.car.Car;
import racingcar.common.util.OutputUtils;
import racingcar.common.util.RandomUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingManager {
    private final List<Car> cars;
    private final int laps;

    public RacingManager(RacingInfo racingInfo) {
        this.cars = IntStream.range(0, racingInfo.getCars())
                .boxed()
                .map(i -> new Car())
                .collect(Collectors.toList());
        this.laps = racingInfo.getLaps();
    }

    public void startRace() {
        System.out.println("실행 결과");
        IntStream.range(0, laps)
                .boxed()
                .peek(this::moveCars)
                .forEach(this::drawingCars);
    }

    protected void moveCars(int index) {
        cars.forEach(car -> car.move(RandomUtils.getNextInt()));
    }

    protected void drawingCars(int index) {
        cars.forEach(car -> System.out.println(OutputUtils.convertLiteral(car.getPosition())));
        System.out.println();
    }
}
