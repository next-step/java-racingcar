package racingcar.domain;

import java.util.List;

public class RacingViews {
    private List<RacingCarPositions> racingCarPositions;

    public RacingViews(List<RacingCarPositions> racingCarPositions) {
        this.racingCarPositions = racingCarPositions;
    }

    public List<RacingCarPositions> get() {
        return racingCarPositions;
    }
}
