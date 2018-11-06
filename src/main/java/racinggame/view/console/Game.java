package racinggame.view.console;

import racinggame.domain.game.RacingGame;
import racinggame.domain.rule.RandomNumberRacing;

public class Game {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(InputView.inpputCarName(), InputView.inputTryCnt(), new RandomNumberRacing());
        while(racingGame.nextRacingGame()){
            racingGame.move();
            resultView.print(racingGame.getCar());
        }
        WinnterView.print(racingGame.getVictorCar());

    }
}
