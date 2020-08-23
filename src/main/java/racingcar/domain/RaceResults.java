package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RaceResults {

    private final List<Car_old> raceResults;

    public RaceResults(){
        this(new ArrayList<>());
    }

    public RaceResults(List<Car_old> raceResults) {
        this.raceResults = raceResults;
    }

    public List<Car_old> getRaceResults() {
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
