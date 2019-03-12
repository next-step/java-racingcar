package racing.board;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private List<String> winners;

    public GameResult(List<String> winners) {
        this.winners = winners;
    }

    public String getWinners() {
        return winners.stream()
                .collect(Collectors.joining(", "));
    }
}
