package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private final List<RoundResult> progress;

    public GameResult() {
        progress = new ArrayList<>();
    }

    public void record(int round, String result) {
        if (isInitRound(round)) {
            progress.add(new RoundResult());
        }

        progress.get(round).record(result);
    }

    private boolean isInitRound(int round) {
        return progress.size() <= round;
    }

    public List<RoundResult> getProgress() {
        return progress;
    }
}
