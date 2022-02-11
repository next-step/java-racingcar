package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(String[] carNameLists) {
        this(Arrays.stream(carNameLists).map(RacingCar::new).collect(Collectors.toList()));
    }

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars race(final Movable movable) {
        final List<RacingCar> history = new ArrayList<>();
        for(final RacingCar racingCar : racingCars) {
            history.add(racingCar.moveForward(movable));
        }
        return new RacingCars(history);
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

}
