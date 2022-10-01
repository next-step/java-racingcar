package racing;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    private final List<RaceResult> raceResults = new ArrayList<>();

    public void addResult(final RaceResult raceResult){
        raceResults.add(raceResult);
    }
}
