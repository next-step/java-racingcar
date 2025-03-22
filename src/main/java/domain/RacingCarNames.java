package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarNames {

    public final List<String> racingCarNames;

    public RacingCarNames(String... racingCarNames) {
        if (isEmpty(racingCarNames)) {
            throw new IllegalArgumentException("자동차 개수는 0보다 많아야 합니다.");
        }
        this.racingCarNames = new ArrayList<>(List.of(racingCarNames));
    }

    public List<String> getRacingCarNames() {
        return racingCarNames;
    }

    public Integer length() {
        return racingCarNames.size();
    }

    private boolean isEmpty(String[] racingCarNames) {
        return racingCarNames.length == 0;
    }
}
