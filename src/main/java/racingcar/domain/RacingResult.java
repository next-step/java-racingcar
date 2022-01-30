package racingcar.domain;

import java.util.List;

public class RacingResult {

    private List<String> result;

    private RacingResult() {
    }

    public static RacingResult instance() {
        return new RacingResult();
    }

    public void registerWinners(final List<String> winners) {
        result = winners;
    }

    public List<String> getResult() {
        return result;
    }
}
