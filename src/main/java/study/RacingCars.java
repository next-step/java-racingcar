package study;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    public static final String HYPHEN = "-";

    private final List<RacingCar> racingCars;

    public RacingCars(int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException();
        }

        racingCars = IntStream.range(0, quantity)
                .mapToObj(i -> new RacingCar())
                .collect(Collectors.toList());

    }

    public void moveRacingCars() {
        racingCars.forEach(racingCar -> racingCar.moveForwardWhenFourHigher(new Random()));
    }

    public void printStatus() {
        racingCars.forEach(racingCar -> System.out.println(HYPHEN.repeat(racingCar.position())));
    }


}
