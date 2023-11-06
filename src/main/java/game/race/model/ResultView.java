package game.race.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static final String END_MARK = "";

    private final Map<Integer, List<String>> results = new HashMap<>();

    public void setNewTireMarks(int idx, List<String> tireMarks) {
        results.put(idx, tireMarks);
    }

    public List<String> getTireMarks(int trial) {
        return results.get(trial);
    }

    public Map<Integer, List<String>> getResults() {
        return results;
    }

    public String markEnd() {
        return END_MARK;
    }
}
