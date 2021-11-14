package step3;

import java.util.List;
import java.util.stream.Collectors;

public class Record {

    private final List<Position> position;

    public Record(List<Position> positions) {
        this.position = positions.stream()
                .collect(Collectors.toList());
    }

    public List<Position> recordList() {
        return position;
    }
}
