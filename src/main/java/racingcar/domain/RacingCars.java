package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void addRacingCars(RacingCar racingCar) {
        this.racingCars.add(racingCar);
    }

    /**
     * 위치를 통한 우승자 선정
     */
    public RacingCars pickWinners() {
        int maxAdvancedCount = racingCars.stream()
                .max(Comparator.comparing(RacingCar::getAdvancedCount))
                .orElseThrow(NoSuchElementException::new)
                .getAdvancedCount();
        List<RacingCar> winners = racingCars.stream()
                .filter(c -> c.getAdvancedCount() == maxAdvancedCount)
                .distinct()
                .collect(Collectors.toList());
        return new RacingCars(winners);
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
        return racingCars != null ? racingCars.hashCode() : 0;
    }

}
