package step5.view;

import step5.controller.game.GameHistory;
import step5.strategy.PrintMarkStrategy;

public interface ResultView {
    void render(GameHistory gameHistory, PrintMarkStrategy strategy);
}
