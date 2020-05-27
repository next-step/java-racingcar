package racing_game.controller;

import java.util.List;
import racing_game.model.Car;
import racing_game.model.RacingGame;
import racing_game.model.RacingGameImpl;
import racing_game.view.RacingGameInput;
import racing_game.view.RacingGameResultView;

public class RacingGameController {
  public static void main(String[] args) {
    RacingGame racingGame = new RacingGameImpl(RacingGameInput.getNameOfCarsByScanner(),
        RacingGameInput.getTimeByScanner());
    List<Car> racingCarList;

    RacingGameResultView.printResultBeginMessage();

    for (int i = 0; i < racingGame.getTime(); i++) {
      racingCarList = racingGame.play();
      RacingGameResultView.printNameAndDistancesOfRacingCarList(racingCarList);
    }

    RacingGameResultView.printWinner(racingGame.getWinnerList());
  }
}
