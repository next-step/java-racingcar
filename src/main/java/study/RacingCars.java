package study;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCars {

    List<RacingCar> racingCars;

    public RacingCars(int quantity) {

        List<RacingCar> racingCars = new ArrayList<>();

        IntStream.range(0, quantity).forEach(i -> {
            RacingCar racingCar = new RacingCar();
            racingCars.add(racingCar);
        });

        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }


}
