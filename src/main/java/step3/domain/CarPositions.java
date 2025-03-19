package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarPositions {
    private final List<String> positions;

    public CarPositions(List<String> positions) {
        this.positions = positions;
    }

    public List<String> getPositions() {
        return new ArrayList<>(positions);
    }
}
