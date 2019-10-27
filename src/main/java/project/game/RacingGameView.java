package project.game;

import java.util.List;

public interface RacingGameView {
    void setController(RacingGameController controller);

    void onCarPositionsChange(List<Integer> carPositions);
}
