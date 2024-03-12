package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundRecord {

    private final List<Integer> positions;

    public RoundRecord() {
        this.positions = new ArrayList<>();
    }

    public void add(int position) {
        positions.add(position);
    }

    public List<Integer> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
