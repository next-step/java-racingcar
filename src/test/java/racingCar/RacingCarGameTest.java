package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

  @Test
  @DisplayName("자동차 경주 게임판을 만들었을 때 예외가 발생하지 않는다")
  void 자동차_경주_게임판_초기화(){
    RacingCarGame racingCarGame = new RacingCarGame();

    assertThatNoException().isThrownBy(() -> racingCarGame.initiateGame(3));
  }

  @Test
  @DisplayName("자동차 경주 게임을 시작하면 경기 라운드 수 만큼의 결과를 전달받는다")
  void 자동차_경주_게임판_시작(){
    int carNum = 3;
    int gameTryNum = 5;
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.initiateGame(carNum);

    List<String> results = racingCarGame.playGames(gameTryNum);

    assertThat(results.size()).isEqualTo(gameTryNum);
  }
}
