package racingcar.dto;

import java.util.List;

public class RoundResult {
    private final List<Integer> carsPositions;

    public RoundResult(List<Integer> carsPositions) {
        this.carsPositions = carsPositions;
    }

    public List<Integer> getCarsPositions() {
        return carsPositions;
    }
}
