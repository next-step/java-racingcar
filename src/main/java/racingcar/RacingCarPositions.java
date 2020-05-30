package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarPositions {
    private final List<RacingCarPosition> racingCarPositions;

    public RacingCarPositions(List<RacingCarPosition> racingCarPositions) {
        this.racingCarPositions = racingCarPositions;
    }

    public List<RacingCarPosition> get() {
        return new ArrayList<>(racingCarPositions);
    }
}
