package step3;

import java.util.List;

public class RoundResultMap {
     int number;
     List<RaceResultMap> raceResultMaps;

    public RoundResultMap(int number, List<RaceResultMap> raceResultMaps) {
        this.number = number;
        this.raceResultMaps = raceResultMaps;
    }
}
