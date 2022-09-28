package racingcarGame;

import racingcarGame.dto.GameData;

import static racingcarGame.client.MessageClient.input;
import static racingcarGame.client.MessageClient.show;

public class GameBoard {

    public static void main(String[] args) {
        ready().start();
    }

    private static Game ready() {
        show("자동차 대수는 몇대 인가요?");
        int playerCount = input();

        show("시도할 회수는 몇 회 인가요?");
        int moveCount = input();

        GameData gameData = new GameData(playerCount, moveCount);

        return new Game(gameData);
    }
}
