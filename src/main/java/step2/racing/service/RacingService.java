package step2.racing.service;

import step2.racing.dto.*;
import step2.racing.model.Car;
import step2.racing.random.RandomGenerator;
import step2.racing.random.RealRandomGenerator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {

    public static final int START_UNIQUE_CAR_NUMBER = 1;
    public static final int START_RACE_COUNT = 0;
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final RacingInfo racingInfo;
    private final RandomGenerator randomGenerator;

    public RacingService(RacingInfo racingInfo) {

        this(racingInfo, new RealRandomGenerator(RANDOM_NUMBER_BOUND));
    }

    public RacingService(RacingInfo racingInfo, RandomGenerator randomGenerator) {

        this.racingInfo = racingInfo;
        this.randomGenerator = randomGenerator;
    }

    public RacingResult run() {

        List<Car> cars = createCars(racingInfo.getCarCount());

        return race(cars);
    }

    private List<Car> createCars(int carCount) {

        return IntStream.rangeClosed(START_UNIQUE_CAR_NUMBER, carCount)
                .mapToObj(Car::of)
                .collect(Collectors.toList());
    }

    private RacingResult race(List<Car> cars) {

        RacingResult racingResult = new RacingResult();
        addCurrentCarPosition(cars, racingResult);

        IntStream.range(START_RACE_COUNT, racingInfo.getAttempts())
                .forEach(currentRaceCount -> {
                    raceEntireCars(cars);
                    addCurrentCarPosition(cars, racingResult);
                });

        return racingResult;
    }

    private void raceEntireCars(List<Car> cars) {

        cars.forEach(car -> car.race(randomGenerator.getRandomIntValue()));
    }

    private void addCurrentCarPosition(List<Car> cars, RacingResult racingResult) {

        Map<Integer, Integer> carNumberPositions = cars.stream()
                .collect(Collectors.toMap(Car::getUniqueNumber, Car::getPosition, (car1, car2) -> car1));

        racingResult.add(new CarPosition(carNumberPositions));
    }
}
