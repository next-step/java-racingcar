package carrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordCarRace {
    private List<Integer> raceInfoBoards = new ArrayList<>();

    public void record(int result) {
        raceInfoBoards.add(result);
    }

    public List<Integer> getRaceInfoBoards() {
        return Collections.unmodifiableList(raceInfoBoards);
    }
}
