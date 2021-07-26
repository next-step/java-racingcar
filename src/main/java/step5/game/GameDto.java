package step5.game;

import step5.model.Cars;

public class GameDto {
    String names;
    int count;

    protected GameDto(String names, int count) {
        this.names = names;
        this.count = count;
    }

    static public GameDto of(String names, int count) {
        return new GameDto(names, count);
    }

    public Game createGame() {
        return Game.of(count, Cars.of(names));
    }
}
