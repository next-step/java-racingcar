package study.nextstep.stage5.view;

import study.nextstep.stage5.domain.GameStatus;

public interface Renderer {
    void render(String[] names, GameStatus status);
    void renderFirstStatus(GameStatus status);
    void renderWinner(String[] names, GameStatus status);
}
