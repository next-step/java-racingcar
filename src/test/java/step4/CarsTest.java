package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  @DisplayName("전진 테스트 : 모든 자동차의 이동을 확인")
  @Test
  void 전진_테스트 () {
    MoveStrategy moveStrategy = new AlwaysMoveStrategy();
    assertThat("a : --,b : --,c : --")
      .isEqualTo(
        Cars.of("a,b,c".split(","))
            .move(moveStrategy)
            .move(moveStrategy)
            .stream()
            .map(v -> v.getPositionString())
            .collect(Collectors.joining(","))
      );
  }
}
