package step3;

import step3.model.RacingGame;
import step3.view.View;

public class RacingGameApp {

    public static void main(String[] args) {

        View view = new View();

        RacingGame racingGame = new RacingGame(view.requestStart());
        racingGame.race();
        view.printResult(racingGame.getResult());
    }
}
