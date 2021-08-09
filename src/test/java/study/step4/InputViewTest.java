package study.step4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step4.model.view.Input;

public class InputViewTest {


  @DisplayName("Car Name Input Test")
  @Test
  public void carNameInputTest() {

    final int CAR_GAME_ROUND = 5;
    final String CAR_NAME_SPLITER = ",";
    final String userCarNameInput = "car12,car123,car1234";

    String[] userCarNameSplited = userCarNameInput.split(CAR_NAME_SPLITER);
    Input userInput = new Input(userCarNameInput, CAR_GAME_ROUND);
    String[] carNames = userInput.getCarNames();

    for (int i = 0; i < carNames.length; i++) {
      System.out.println(carNames[i] + " , " + userCarNameSplited[i]);
      assertThat(carNames[i]).isEqualTo(userCarNameSplited[i]);
    }
  }

}
