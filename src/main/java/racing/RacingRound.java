package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingRound {

    private final List<Cars> racingRound = new ArrayList<>();

    public void addRacingResult(Cars cars) {
        racingRound.add(cars);
    }

    public Cars getLastRoundResult() {
        return racingRound.get(racingRound.size() - 1);
    }

    public int size() {
        return racingRound.size();
    }
}
