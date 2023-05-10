package study;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(int quantity) {
        if(quantity <= 0) {
            throw new IllegalArgumentException();
        }

        racingCars = IntStream.range(0, quantity)
                .mapToObj(i -> new RacingCar())
                .collect(Collectors.toList());

    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }


}
