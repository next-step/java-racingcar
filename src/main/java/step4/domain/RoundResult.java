package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {
    private final List<Integer> roundList = new ArrayList<>();

    public List<Integer> roundList() {
        return Collections.unmodifiableList(this.roundList);
    }

    public void add(int distance) {
        roundList.add(distance);
    }
}
