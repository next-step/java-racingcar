package project.game;

import java.util.List;

public interface RacingGameNotifier {
    void onResultRacingRound(List<Integer> carPositions);
    void onResultRacingWinnerNames(List<String> winnerNames);
}
