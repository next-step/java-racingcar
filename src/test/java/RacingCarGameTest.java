import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarGameTest {

  @Test
  @DisplayName("게임을 진행했을 때 결과리스트의 사이즈가 RacingCarGame 생성자의 chanceAmount와 같은지 검증하는 통합 테스트")
  void playWithRandomMoveStrategy() {
    // given
    int carAmount = 3;
    int chanceAmount = 5;
    RacingCarGame racingCarGame = new RacingCarGame(carAmount, chanceAmount);

    // when
    racingCarGame.play(new RandomMoveStrategy());

    // then
    List<List<Integer>> resultList = racingCarGame.getResults().getResultList();
    assertThat(resultList).hasSize(5);
  }

  @Test
  @DisplayName("항상 움직이는 전략으로 게임을 진행했을 때, 실제 자동차가 전진했는지 검증하는 통합 테스트")
  void playWithAlwaysMoveStrategy() {
    // given
    int carAmount = 3;
    int chanceAmount = 1;
    int expectedMovedDistance = chanceAmount;
    MoveStrategy alwaysMoveStrategy = () -> true;
    RacingCarGame racingCarGame = new RacingCarGame(carAmount, chanceAmount);

    // when
    racingCarGame.play(alwaysMoveStrategy);

    // then
    List<List<Integer>> resultList = racingCarGame.getResults().getResultList();
    assertThat(resultList.size()).isEqualTo(chanceAmount);
    resultList.get(0).forEach(movedDistance ->
      assertThat(movedDistance).isEqualTo(expectedMovedDistance)
    );
  }

}
