package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(int countOfCar) {
        this.racingCars = new ArrayList<>();
        participate(countOfCar);
    }

    private List<RacingCar> participate(int countOfCar) {
        for (int i = 0; i < countOfCar; i++) {
            racingCars.add(new RacingCar());
        }
        return this.racingCars;
    }

    public RacingRound racing(MoveRule moveRule) {
        return new RacingRound(racingCars.stream()
                .map(racingCar -> racingCar.run(moveRule))
                .collect(Collectors.toList()));
    }

    public List<RacingCar> getParticipatingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
