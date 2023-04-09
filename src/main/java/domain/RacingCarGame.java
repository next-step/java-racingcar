package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {
    private final List<RacingCar> cars;

    public RacingCarGame(int carCount) {
        this.cars = createCars(carCount);
    }

    private static List<RacingCar> createCars(int carCount) {
        return Stream.generate(RacingCar::new)
                .limit(carCount)
                .collect(Collectors.toList());
    }

    public List<RacingCar> playAndReturnCars() {
        for (RacingCar car : cars) {
            car.moveForward(RandomNumberGenerator.generateRandomNumber());
        }
        return cars;
    }
}
