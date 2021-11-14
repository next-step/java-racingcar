package racingcar.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class GameResult {

    private final List<RoundResult> progress;

    public GameResult() {
        progress = new ArrayList<>();
    }

    public void record(int round, Car car) {
        if (isInitRound(round)) {
            progress.add(new RoundResult());
        }

        progress.get(round).record(car);
    }

    private boolean isInitRound(int round) {
        return progress.size() <= round;
    }

    public List<RoundResult> getProgress() {
        return progress;
    }
}
