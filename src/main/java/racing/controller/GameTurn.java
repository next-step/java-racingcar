package racing.controller;

public class GameTurn {

    private final int gameTurn;

    public GameTurn(int gameTurn) {
        if (gameTurn == 0) {
            throw new IllegalArgumentException("게임 턴은 0이상이여야 합니다.");
        }
        this.gameTurn = gameTurn;
    }

    public int getGameTurn() {
        return this.gameTurn;
    }
}
