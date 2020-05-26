package study.nextstep.stage4;

public interface Renderer {
    void render(String[] names, GameStatus status);
    void renderFirstStatus(GameStatus status);
    void renderWinner(String[] names, GameStatus status);
}
