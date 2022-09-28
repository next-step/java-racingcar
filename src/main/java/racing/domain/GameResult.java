package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<GameRound> gameRoundList = new ArrayList<>();

    public void addRound(GameRound gameRound) {
        this.gameRoundList.add(gameRound);
    }

    public List<GameRound> getGameRoundList() {
        return gameRoundList;
    }
}