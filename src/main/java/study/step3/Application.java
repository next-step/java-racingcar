package study.step3;

import study.step3.model.Count;
import study.step3.view.InputView;
import study.step3.view.View;

public class Application {
    public static void main(String[] args) {
        View view = new View();

        Count count = view.input();
        view.result();

        GameConfig gameConfig = new GameConfig(count.getGame(), count.getCar());
        RacingGame racingGame = new RacingGame(gameConfig.getCars());

        for (int i = 0; i < gameConfig.getGameCount(); i++) {
            racingGame.play();
            view.carStatus(racingGame.getCars());
        }
    }
}
