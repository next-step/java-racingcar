package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step3.model.RacingGame;
import study.step3.model.car.Car;
import study.step3.view.InputView;

public class RacingGameTest {


  @Test
  @DisplayName("자동차 대수 입력 테스트")
  public void carNumberInputTest() {
    String userCarNumber = "3";
    InputStream in = new ByteArrayInputStream(userCarNumber .getBytes());
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


  @ParameterizedTest
  @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1"})
  @DisplayName("Car Move Test")
  void move(int inputCarDistance, int expectedCarDistance) {
    int userCarNumber = 3;
    int userGameRound = 5;
    RacingGame racingGame = new RacingGame(userCarNumber, userGameRound);

    for(Car car : racingGame.getCars().getRacingGameCars()) {
      car.move(inputCarDistance);
      assertThat(car.getDistance()).isEqualTo(expectedCarDistance);
    }
  }

  @ParameterizedTest
  @DisplayName("Car Racing Game 진행 테스트")
  @CsvSource(value = {"3,5", "3,3"})
  public void carRacingGameStartTest(int userCarNumber, int userGameRound) {
    RacingGame racingGame = new RacingGame(userCarNumber, userGameRound);
    assertDoesNotThrow(racingGame::start);
  }
}
