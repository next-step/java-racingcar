package racingCar.domain;

import java.util.Collections;
import java.util.List;

public class WinnerGroup {
    private final List<Car> winnerGroup;

    public WinnerGroup(List<Car> winnerGroup) {
        this.winnerGroup = winnerGroup;
    }

    public List<Car> getWinnerGroup() {
        return Collections.unmodifiableList(winnerGroup);
    }
}
