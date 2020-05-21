package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import step5.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  private static MoveStrategy moveStrategy = AlwaysMoveStrategy.getInstance();

  @DisplayName("Cars 전진 테스트 : 모든 자동차의 이동을 확인")
  @Test
  void 전진_테스트 () {
    assertThat("a : --,b : --,c : --")
      .isEqualTo(
        Cars.of("a,b,c".split(","))
          .move(moveStrategy).move(moveStrategy)
          .stream()
          .map(ResultView::getCarPositionString)
          .collect(Collectors.joining(","))
      );
  }
}
