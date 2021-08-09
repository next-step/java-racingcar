package study.step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step4.model.RacingGame;
import study.step4.model.view.Input;
import study.step4.view.InputView;

public class RacingGameTest {


  @Test
  @DisplayName("자동차 대수 입력 테스트")
  public void carNumberInputTest() {
    String userCarNumber = "3";
    InputStream in = new ByteArrayInputStream(userCarNumber.getBytes());
    System.setIn(in);

    InputView inputView = new InputView();
    int carNumber = inputView.getCarNumber();

    assertThat(carNumber).isEqualTo(Integer.parseInt(userCarNumber));
  }

  @Test
  @DisplayName("Car Racing Game Round 입력 테스트")
  public void carRacingGameRoundrInputTest() {
    String userGameRound = "5";
    InputStream in = new ByteArrayInputStream(userGameRound.getBytes());
    System.setIn(in);

    InputView inputView = new InputView();
    int gacingGameRound = inputView.getRacingGameRound();

    assertThat(gacingGameRound).isEqualTo(Integer.parseInt(userGameRound));
  }

  @DisplayName("Car Racing Game 진행 테스트")
  @Test
  public void carRacingGameStartTest() {

    final int CAR_GAME_ROUND = 5;
    final String userCarNameInput = "car1,car2,car3";

    Input userInput = new Input(userCarNameInput, CAR_GAME_ROUND);
    String[] carNames = userInput.getCarNames();

    RacingGame racingGame = new RacingGame(carNames, CAR_GAME_ROUND);
    assertDoesNotThrow(racingGame::start);
  }
}
