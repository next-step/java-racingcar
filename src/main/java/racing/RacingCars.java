package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingCars {

    public static final String SPLITTER = ",";

    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public static RacingCars init(final String carNames) {
        List<RacingCar> racingCars = Arrays.stream(carNames.split(SPLITTER))
                .map(RacingCar::init)
                .collect(Collectors.toList());
        return new RacingCars(racingCars);
    }

    public static RacingCars init(final String carNames, final String locations) {
        String[] carNameList = carNames.split(SPLITTER);
        String[] locationList = locations.split(SPLITTER);

        List<RacingCar> racingCars = new ArrayList<>();
        for (int i=0; i < carNameList.length; i++) {
            racingCars.add(
                    RacingCar.init(Integer.parseInt(locationList[i]), carNameList[i])
            );
        }
        return new RacingCars(racingCars);
    }

    public RacingCars race(final RacingGameSpec racingGameSpec) {
        List<RacingCar> movedRacingCars = this.racingCars
                .stream()
                .map(car -> car.move(racingGameSpec.moveCount()))
                .collect(Collectors.toList());

        return new RacingCars(movedRacingCars);
    }

    public Optional<RacingCar> getRacingCar(String name) {
        return racingCars.stream()
                .filter(car -> car.getName().equals(name))
                .findFirst();
    }
}
