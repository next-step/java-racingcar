package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.Objects;

public class RaceResults {

    private final List<Car> raceResults;

    public RaceResults(List<Car> raceResults) {
        this.raceResults = raceResults;
    }

    public List<Car> getRaceResults() {
        return raceResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RaceResults that = (RaceResults) o;
        return Objects.equals(raceResults, that.raceResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceResults);
    }
}
