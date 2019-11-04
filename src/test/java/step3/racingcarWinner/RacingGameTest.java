package step3.racingcarWinner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

  private static String inputName = "pobi,crong,honux";
  private static int inputTryCount = 5;

  private RacingGame racingGame = new RacingGame(inputName, inputTryCount);

  @DisplayName("입력받은 값만큼 자동차수가 생성되는지 확인")
  @Test
  void initNumberOfCarArray() {
    assertThat(racingGame.splitTextToNumberOfCars(inputName)).isEqualTo(3);
  }

  @DisplayName("입력한 값과 일치하는 자동차가 생성되는지 확인")
  @Test
  void createCarInform() {
    Car car = new Car("pobi", 3);
    assertThat(car.getName()).isEqualTo("pobi");
    assertThat(car.getPosition()).isEqualTo(3);
  }
}