package study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(int quantity) {

        racingCars = new ArrayList<>();

        IntStream.range(0, quantity).forEach(i -> {
            RacingCar racingCar = new RacingCar();
            racingCars.add(racingCar);
        });

    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }


}
