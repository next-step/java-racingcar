import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

  @Test
  @DisplayName("게임을 진행했을 때 결과리스트의 사이즈가 RacingCarGame 생성자의 chanceAmount와 같은지 검증하는 통합 테스트")
  void play() {
    // given
    int carAmount = 3;
    int chanceAmount = 5;
    RacingCarGame racingCarGame = new RacingCarGame(carAmount, chanceAmount);

    // when
    racingCarGame.play();

    // then
    List<List<Integer>> resultList = racingCarGame.getResults().getResultList();
    assertThat(resultList).hasSize(5);
  }

}
