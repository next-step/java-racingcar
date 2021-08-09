package study.step4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step4.model.RacingGame;
import study.step4.model.view.Result;
import study.step4.view.ResultView;

public class ResultViewTest {

  @DisplayName("Car Name Output Test")
  @Test
  public void carNameOutputTest() {

    final int CAR_GAME_ROUND = 5;
    final String CAR_NAME_SPLITER = ",";
    final String userCarNameInput = "car1,car2,car3";

    String[] userCarNameSplited = userCarNameInput.split(CAR_NAME_SPLITER);

    RacingGame racingGame = new RacingGame(userCarNameSplited, CAR_GAME_ROUND);

    ResultView resultView = new ResultView(racingGame.getCars());
    Result result = resultView.getResult();

    for (int i = 0; i < result.getRacingGameCars().size(); i++) {
      System.out
          .println(result.getRacingGameCars().get(i).getName() + " , " + userCarNameSplited[i]);
      assertThat(result.getRacingGameCars().get(i).getName()).isEqualTo(userCarNameSplited[i]);
    }
  }

}
