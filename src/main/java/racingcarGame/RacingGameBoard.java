package racingcarGame;

import racingcarGame.dto.GameData;

import static racingcarGame.client.InputView.getCarCount;
import static racingcarGame.client.InputView.getPlayCount;

public class RacingGameBoard {

    public static void main(String[] args) {
        ready().start();
    }

    private static RacingGame ready() {
        GameData gameData = new GameData(getCarCount(), getPlayCount());

        return new RacingGame(gameData);
    }
}
