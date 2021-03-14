package carRacing.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {

    public static final Random random = new Random();

    public List<Car> race(List<Car> cars) {
        return cars.stream()
                .map(car -> car.raceOrStay(car, random.nextInt()))
                .collect(Collectors.toList());
    }

}
