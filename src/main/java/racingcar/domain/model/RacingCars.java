package racingcar.domain.model;

import java.util.ArrayList;
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

    public RacingCars findWinners() {
        return RacingCars.of(filterWinners(getWinnerPosition()));
    }

    public List<RacingCar> findAll() {
        return new ArrayList<>(racingCars);
    }

    private List<RacingCar> filterWinners(Position winnerPosition) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.isWinner(winnerPosition))
                .collect(Collectors.toList());
    }
    private Position getWinnerPosition() {
        return Position.of(racingCars.stream()
                .mapToInt(racingCar -> racingCar.getPosition().get())
                .max().orElse(0));
    }
}
