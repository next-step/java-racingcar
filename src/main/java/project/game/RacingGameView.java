package project.game;

import java.util.List;

public interface RacingGameView {
    void setController(RacingGameController controller);

    void onStartGame();
    void onEndGame();
    void onCarPositionsChange(List<Integer> carPositions);
}
