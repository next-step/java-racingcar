package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.GameResult;
import racingCar.domain.RacingCarGame;

public class RacingCarGameTest {

  RacingCarGame racingCarGame;
  @BeforeEach
  void setUp() {
    racingCarGame = new RacingCarGame();
  }
  @Test
  @DisplayName("자동차 경주 게임판을 만들었을 때 예외가 발생하지 않는다")
  void 자동차_경주_게임판_초기화(){
    List<String> carNames = List.of("pobi", "crong", "honux");
    assertThatNoException().isThrownBy(() -> racingCarGame.initiateGame(carNames));
  }

  @Test
  @DisplayName("자동차 경주 게임을 시작하면 경기 라운드 수 만큼의 결과를 전달받는다")
  void 자동차_경주_게임판_시작(){
    List<String> carNames = List.of("pobi", "crong", "honux", "hoi");
    int gameTryNum = 5;
    racingCarGame.initiateGame(carNames);

    GameResult results = racingCarGame.playGames(gameTryNum);

    assertThat(results.getRoundResults().size()).isEqualTo(gameTryNum);
  }

  @Test
  @DisplayName("자동차 경주 게임은 최소 한명의 우승자가 있다")
  void checkWinnerAtleastOne(){
    List<String> carNames = List.of("pobi", "crong", "honux", "hoi", "mizu");
    int gameTryNum = 5;
    racingCarGame.initiateGame(carNames);

    GameResult gameResult = racingCarGame.playGames(gameTryNum);

    assertThat(gameResult.getWinners()).isNotEmpty();
    assertThat(gameResult.getWinners().size()).isGreaterThan(0);
  }
}
