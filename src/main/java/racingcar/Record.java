package racingcar;

import java.util.List;

public class Record {
    private List<Integer> positions;

    public Record(List<Integer> positions) {
        this.positions = positions;
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
