package racinggame.dto;

import java.util.List;

public class Result {
    private final History history;
    private final List<String> winners;

    public Result(History history, List<String> winners) {
        this.history = history;
        this.winners = winners;
    }

    public int repeatCount() {
        return history.repeatCount();
    }

    public List<CarDto> getSnapShot(int idx) {
        return history.getSnapShot(idx);
    }

    public List<String> getWinner() {
        return winners;
    }
}
