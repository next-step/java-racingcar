package racingcarrefectoring.controller;

import racingcarrefectoring.model.Cars;
import racingcarrefectoring.model.Game;
import racingcarrefectoring.view.InputView;
import racingcarrefectoring.view.ResultView;

public class MainController {

    public static void main(String[] args) {
        play();
    }

    public static void play(){
        Game game = new Game(InputView.inputCarsName(),InputView.inputRoundCount());

        ResultView.resultMessage();
        ResultView.viewWinners(game.play());
    }

    public static void relayBroadcastRound(Cars cars){
        ResultView.relayBroadCaseView(cars);
    }
}
