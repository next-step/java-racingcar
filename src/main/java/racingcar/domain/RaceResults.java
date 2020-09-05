package racingcar.domain;
import racingcar.domain.car.Cars;

import java.util.Map;
import java.util.Objects;

public class RaceResults {

    private final int raceSeq;
    private final Map<String, Integer> raceHist;

    RaceResults(int raceSeq, Map<String, Integer> raceHist) {
        this.raceSeq = raceSeq;
        this.raceHist = raceHist;
    }

    public int getRaceSeq() {
        return raceSeq;
    }

    public Map<String, Integer> getRaceHist() {
        return raceHist;
    }

    public static RaceResults of(int i, Cars cars) {
        return new RaceResults(i, cars.getRaceHist());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RaceResults that = (RaceResults) o;
        return raceSeq == that.raceSeq &&
                Objects.equals(raceHist, that.raceHist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceSeq, raceHist);
    }
}
