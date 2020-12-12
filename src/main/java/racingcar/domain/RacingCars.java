package racingcar.domain;

import racingcar.RacingCar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        if (racingCars != null) {
            this.racingCars = racingCars;
            return;
        }
        this.racingCars = new ArrayList<RacingCar>();
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

    @Override
    public String toString() {
        return "RacingCars{" +
                "racingCars=" + racingCars +
                '}';
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    /**
     * 우승자(가장 멀리 간 자동차)의 이름을 리스트에 담습니다.
     * @return
     */
    public List<String> findWinner() {
        int longestDistance = this.findLongestDistance();
        return this.racingCars.stream()
                .filter(racingCar -> {
                    return racingCar.getDistance() >= longestDistance;})
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    /**
     * 가장 긴 거리를 찾습니다.
     * @return longest distance
     */
    private int findLongestDistance() {
        return this.racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getDistance))
                .map(RacingCar::getDistance)
                .orElseThrow(RuntimeException::new);
    }
}
