package racingcarGame;

import racingcarGame.dto.GameData;

import static racingcarGame.client.InputView.getCarCount;
import static racingcarGame.client.InputView.getPlayCount;

public class GameBoard {

    public static void main(String[] args) {
        ready().start();
    }

    private static Game ready() {
        GameData gameData = new GameData(getCarCount(), getPlayCount());

        return new Game(gameData);
    }
}
