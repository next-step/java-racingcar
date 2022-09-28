package racingcarGame;

import racingcarGame.client.ResultView;
import racingcarGame.dto.GameData;
import racingcarGame.util.RandomNumber;

import java.util.Objects;

import static racingcarGame.client.ResultView.nextLine;
import static racingcarGame.client.ResultView.showCarPosition;
import static racingcarGame.dto.GameData.getRandomBaseValue;

public class Game {
    private final GameData gameData;

    public Game(GameData gameData) {
        this.gameData = gameData;
    }

    public void start() {
        ResultView.resultGame();

        for (int i = 0; i < gameData.getPlayCount(); i++) {
            playRound();
            nextLine();
        }
    }

    private void playRound() {
        gameData.getCars().forEach(car -> {
            int randomNumber = RandomNumber.generate();

            if (isMovable(randomNumber)) {
                showCarPosition(car.move());
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
        Game game = (Game) o;
        return Objects.equals(gameData, game.gameData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameData);
    }

}
