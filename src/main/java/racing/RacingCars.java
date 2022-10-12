package racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    public static final String SPLITTER = ",";

    private final List<RacingCar> racingCars;

    private RacingCars(String carNames) {
        List<String> carNameList = List.of(carNames.split(SPLITTER));
        racingCars = carNameList.stream()
                .map(RacingCar::init)
                .collect(Collectors.toList());
    }

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public static RacingCars init(final String carNames) {
        return new RacingCars(carNames);
    }

    public RacingCars race(RacingGameSpec racingGameSpec) {
        List<RacingCar> movedRacingCars = this.racingCars
                .stream()
                .map(car -> car.move(racingGameSpec.moveCount()))
                .collect(Collectors.toList());

        return new RacingCars(movedRacingCars);
    }
}
