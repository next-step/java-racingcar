package racingcarGame;

import racingcarGame.client.ResultView;
import racingcarGame.dto.GameData;
import racingcarGame.util.RandomNumber;

import java.util.Objects;

import static racingcarGame.client.ResultView.showResult;
import static racingcarGame.dto.GameData.getRandomBaseValue;

public class RacingGame {
    private final GameData gameData;

    public RacingGame(GameData gameData) {
        this.gameData = gameData;
    }

    public void start() {
        ResultView.showResultGame();

        for (var i = 0; i < gameData.getPlayCount(); i++) {
            play();
            showResult(gameData.getCars());
        }
    }

    private void play() {
        gameData.getCars().forEach(car -> {
            int randomNumber = RandomNumber.generate();

            if (isMovable(randomNumber)) {
                car.move();
            }
        });
    }

    static boolean isMovable(int num) {
        return num >= getRandomBaseValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame racingGame = (RacingGame) o;
        return Objects.equals(gameData, racingGame.gameData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameData);
    }

}
