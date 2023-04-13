package stepRacingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.RacingCarGame;
import util.RandomUtils;

public class RacingCarGameTest {

  @DisplayName("[RacingCarGame.class] 레이싱카 게임은 사용자가 입력한 숫자만큼 레이싱카가 설정된다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void 사용자_입력만큼_레이싱카_세팅(int racingCarCnt) {
    // when
    RacingCarGame racingCarGame = new RacingCarGame(racingCarCnt);

    // then
    Assertions.assertThat(racingCarGame)
        .extracting("racingCarList")
        .asList()
        .hasSize(racingCarCnt);
  }

  @DisplayName("[RacingCarGame.class] 레이싱카 게임 시작 후 레이싱카의 숫자에는 변함이 없다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  public void 레이싱카_게임_시작_후_레이싱카의_숫자에는_변경_없음(int racingCarCnt) {
    // given
    RacingCarGame racingCarGame = new RacingCarGame(racingCarCnt);

    // when
    racingCarGame.play(RandomUtils.getRandomSinglePositiveDigit());

    // then
    Assertions.assertThat(racingCarGame)
        .extracting("racingCarList")
        .asList()
        .hasSize(racingCarCnt);
  }
}
