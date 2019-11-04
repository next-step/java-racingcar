package step3.racingcarWinner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

  private static String inputValue = "pobi,crong,honux";
  private static int inputTryCount = 5;

  private RacingGame racingGame = new RacingGame(inputValue,inputTryCount);

  @DisplayName("입력받은 값만큼 자동차수가 생성되는지 확인")
  @Test
  void initNumberOfCarArray() {
    assertThat(racingGame.splitTextToNumberOfCars(inputValue)).isEqualTo(3);
  }


}