package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MoveResults {

    private List<int[]> results = new ArrayList<>();

    public void add(int[] result) {
        results.add(result);
    }

    public int size() {
        return results.size();
    }

    public int[] get(int index) {
        return results.get(index);
    }
}
