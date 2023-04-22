package carracing.model;

import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private final List<String> names;
    private final List<List<String>> results;

    public Presenter() {
        names = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void addDisplay(String name, List<String> result) {
        names.add(name);
        results.add(result);
    }

    public List<String> roundList(int roundIndex) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < results.get(0).size(); i++) {
            stringList.add(results.get(roundIndex).get(i));
        }
        return stringList;
    }

    public String participateName(int index) {
        return names.get(index);
    }

    public String totalParticipateNames() {
        return String.join(",", names);
    }

    public int iterationCount() {
        return results.get(0).size();
    }

    public int participateCount() {
        return results.size();
    }

    public String getRecord(int i, int j) {
        return this.roundList(j).get(i);
    }
}
