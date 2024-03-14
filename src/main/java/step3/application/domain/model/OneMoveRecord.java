package step3.application.domain.model;

import java.util.List;

public class OneMoveRecord {
    private final List<Integer> carLocation;

    public OneMoveRecord(List<Integer> carLocation) {
        this.carLocation = carLocation;
    }

    public List<Integer> getCarLocation() {
        return carLocation;
    }
}
