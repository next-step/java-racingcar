package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> racingCars;

    RacingGame(String... carNames) {
        this.racingCars = new ArrayList<>();
        this.initRacingCars(carNames);
    }

    RacingGame(List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    private void initRacingCars(String... carNames) {
        Arrays.asList(carNames)
                .forEach(carName -> this.racingCars.add(new RacingCar(carName)));
    }

    public List<RacingCar> play() throws CloneNotSupportedException {
        List<RacingCar> playCars = new ArrayList<>(this.racingCars.size());

        for (RacingCar racingCar : this.racingCars) {
            RacingCar newRacingCar = (RacingCar) racingCar.clone();
            newRacingCar.moveRandomly();

            playCars.add(newRacingCar);
        }

        this.racingCars = playCars;

        return this.racingCars;
    }

    public List<RacingCar> determineWinners() {
        final Comparator<RacingCar> racingCarComparator = Comparator.naturalOrder();

        final RacingCar racingCarWinner = this.racingCars.stream()
                .max(racingCarComparator)
                .get();

        final List<RacingCar> racingCarWinners = this.racingCars.stream()
                .filter(racingCar -> racingCar.compareTo(racingCarWinner) == 0)
                .collect(Collectors.toList());

        return racingCarWinners;
    }
}
