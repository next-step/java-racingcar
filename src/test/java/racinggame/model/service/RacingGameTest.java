package racinggame.model.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import racinggame.view.RacingGameResultView;

public class RacingGameTest {

  RacingGame racingGame;

  @ParameterizedTest
  @CsvSource({"test1 test2 test3, 3"})
  @DisplayName("게임 진행 테스트")
  void play(String carNameInput, int time) {
    RacingGameResultView.printResultBeginMessage();

    racingGame = new RacingGameImpl(carNameInput.split(" "), time);
    while(racingGame.isNotEnd()){
      RacingGameResultView.printNameAndDistancesOfRacingCarList(racingGame.play());
    }

    RacingGameResultView.printWinner(racingGame.getWinnerList());
  }
}
