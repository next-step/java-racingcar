package racing;

import java.util.List;

public class GameResult {
    private final List<RoundResult> roundResultList;


    public GameResult(List<RoundResult> gameResult) {
        roundResultList = gameResult;
    }

    public int totalRound() {
        return roundResultList.size();
    }

    public RoundResult valueOfRoundResult(int i) {
        return roundResultList.get(i);
    }
}
