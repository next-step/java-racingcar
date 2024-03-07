package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

  @Test
  void 자동차_경주_게임판_초기화(){
    RacingCarGame racingCarGame = new RacingCarGame();

    assertThatNoException().isThrownBy(() -> racingCarGame.initiateGame(3));
  }

  @Test
  void 자동차_경주_게임판_시작(){
    int carNum = 3;
    int gameTryNum = 5;
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.initiateGame(carNum);

    List<String> results = racingCarGame.playGames(gameTryNum);

    assertThat(results.size()).isEqualTo(gameTryNum);
  }
}
