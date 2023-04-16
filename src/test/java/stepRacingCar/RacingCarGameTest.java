package stepRacingCar;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.RacingCarGame;
import racingCar.car.move.RacingCarMoveDirectionStrategy;
import racingCar.car.move.RacingCarMoveForward;
import racingCar.exception.NotAllowedGameSettingException;
import racingCar.view.RacingCarGameResultView;

public class RacingCarGameTest {
  List<RacingCarMoveDirectionStrategy> allowedMoveStrategies;

  @BeforeEach
  void setup() {
    allowedMoveStrategies = List.of(new RacingCarMoveForward());
  }

  @DisplayName("[RacingCarGame.class] 레이싱카 게임은 사용자가 입력한 숫자만큼 레이싱카가 설정된다.")
  public void 사용자_입력만큼_레이싱카_세팅() {

    final List<String> 레이싱카_목록 = List.of("car1");
    // when
    RacingCarGame racingCarGame = new RacingCarGame(레이싱카_목록, new RacingCarGameResultView(), allowedMoveStrategies);

    // then
    Assertions.assertThat(racingCarGame)
        .extracting("racingCars")
        .asList()
        .isEqualTo(레이싱카_목록);
  }

  @DisplayName("[RacingCarGame.class] 레이싱카 게임은 게임 턴마다 자동차 움직임을 기록한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  public void 레이싱카_게임은_매_이동마다_기록을_가지고_있음(int moveTryCnt) {
    // given
    final List<String> 레이싱카_목록 = List.of("car1");
    RacingCarGame racingCarGame = new RacingCarGame(레이싱카_목록, new RacingCarGameResultView(), allowedMoveStrategies);

    // when
    racingCarGame.play(moveTryCnt);

    // then
    Assertions.assertThat(racingCarGame)
        .extracting("resultView.snapShots")
        .asList()
        .hasSize(moveTryCnt);
  }

  @DisplayName("[RacingCarGame.class] 레이싱카가 한대도 존재하지 않으면 게임을 시작 할 수 없다.")
  @Test
  public void 레이싱카_게임은_최소_한대의_자동차가_요구된다() {
    // given
    final List<String> 레이싱카_목록 = Collections.emptyList();

    // when && then
    Assertions.assertThatThrownBy(() -> new RacingCarGame(레이싱카_목록, new RacingCarGameResultView(), allowedMoveStrategies))
        .isInstanceOf(NotAllowedGameSettingException.class);
  }
}
