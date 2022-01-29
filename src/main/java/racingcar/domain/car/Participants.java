package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.racing.RacingResult;
import racingcar.domain.random.RandomGenerator;

public class Participants {

    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants createCars(String[] names) {
        List<Car> cars;
        cars = Arrays.stream(names)
            .map(name -> Car.from(name.trim()))
            .collect(Collectors.toList());
        return new Participants(cars);
    }

    public RacingResult race() {
        cars.stream().forEach(car -> car.go(new RandomGenerator()));

        return RacingResult.getInstance(cars);
    }

    public List<Car> getParticipants() {
        return this.cars;
    }
}
