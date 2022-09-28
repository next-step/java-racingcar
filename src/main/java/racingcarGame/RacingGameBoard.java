package racingcarGame;

import racingcarGame.dto.GameData;

import static racingcarGame.client.InputView.scanCarCount;
import static racingcarGame.client.InputView.scanPlayCount;

public class RacingGameBoard {

    public static void main(String[] args) {
        ready().start();
    }

    private static RacingGame ready() {
        int carCount = scanCarCount();
        int playCount = scanPlayCount();

        GameData gameData = new GameData(carCount, playCount);

        return new RacingGame(gameData);
    }
}
