package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {

    private final List<Car> raceResults;

    public RaceResults(){
        this(new ArrayList<>());
    }

    public RaceResults(List<Car> raceResults) {
        this.raceResults = raceResults;
    }

    public List<Car> getRaceResults() {
        return raceResults;
    }





}
