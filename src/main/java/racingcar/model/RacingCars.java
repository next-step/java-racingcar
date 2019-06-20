package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public void move() {
        racingCars = racingCars.stream()
                .map(RacingCar::tryMove)
                .collect(Collectors.toList());
    }

    public List<CarPosition> getCarPosition() {
        return racingCars.stream()
                .map(racingCar -> new CarPosition(racingCar.getName(), racingCar.getPosition()))
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition().equals(getWinnerPosition()))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max().orElse(0);
    }
}
