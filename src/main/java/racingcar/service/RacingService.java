package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.CarStateInRace;
import racingcar.domain.MovingResult;
import racingcar.domain.RacingResult;
import racingcar.domain.movable.RandomForwardStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {

    private final Cars cars;
    private final MovingResult movingResult;
    private final RacingResult racingResult;

    private RacingService(final Cars cars) {
        this.cars = cars;
        this.movingResult = MovingResult.instance();
        this.racingResult = RacingResult.instance();
    }

    private RacingService(final Cars cars, final MovingResult movingResult,
        final RacingResult racingResult) {
        this.cars = cars;
        this.movingResult = movingResult;
        this.racingResult = racingResult;
    }

    public static RacingService from(final Cars cars) {
        return new RacingService(cars);
    }

    public static RacingService of(final Cars cars, final MovingResult movingResult,
        final RacingResult racingResult) {
        return new RacingService(cars, movingResult, racingResult);
    }

    public void drive() {
        IntStream.range(0, cars.getCars().size())
            .forEach(idx -> {
                cars.getCars().get(idx).moveForward();
                CarStateInRace carState = new CarStateInRace(cars.getCars().get(idx));
                carState.convertCurrentCarStatement();
                movingResult.storeCurrentRoundStatement(carState);
            });
    }

    public RacingResult judgeWinners() {
        final int maxPosition = maxDriveLength();
        racingResult.registerWinners(cars.getCars().stream()
            .filter(car -> (car.getStep() == maxPosition && car.getStep() > 0))
            .map(Car::getName)
            .collect(Collectors.toList()));

        return racingResult;
    }

    private int maxDriveLength() {
        return cars.getCars().stream()
            .mapToInt(Car::getStep)
            .max()
            .getAsInt();
    }

    public void registerCars(final List<String> splitUserInput) {
        for (String carName : splitUserInput) {
            cars.getCars().add(Car.of(carName, new RandomForwardStrategy()));
        }
    }

    public MovingResult getMovingResult() {
        return movingResult;
    }

}
