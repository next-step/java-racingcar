package study.nextstep.stage5.view;

import study.nextstep.stage5.domain.GameStatus;

public interface Renderer {
    void render(GameStatus status);
    void renderFirstStatus(GameStatus status);
    void renderWinner(String[] names, GameStatus status);
}
