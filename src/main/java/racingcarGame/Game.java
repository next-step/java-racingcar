package racingcarGame;

import racingcarGame.dto.GameData;

import static racingcarGame.client.MessageClient.nextLine;
import static racingcarGame.client.MessageClient.show;

public class Game {
    private final GameData gameData;

    public Game(GameData gameData) {
        this.gameData = gameData;
    }

    public void start() {
        show("실행 결과");

        for (int i = 0; i < gameData.getPlayCount(); i++) {
            play();
            nextLine();
        }
    }

    void play() {
        gameData.getCars().forEach(car -> {
            car.move().showMovement();
        });
    }

}
