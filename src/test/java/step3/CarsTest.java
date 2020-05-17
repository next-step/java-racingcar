package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {

  @DisplayName("전진 테스트 : 모든 자동차의 이동을 확인")
  @Test
  void 전진_테스트 () {
    MoveStrategy moveStrategy = new AlwaysMoveStrategy();
    assertThat("--,--,--")
      .isEqualTo(
        Cars.of(3).move(moveStrategy)
                  .move(moveStrategy)
                  .stream()
                  .map(v -> v.getPositionString())
                  .collect(Collectors.joining(","))
      );
  }

  public static class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean isMoved() {
      return true;
    }

    @Override
    public boolean isMoved(int number) {
      return true;
    }
  }
}
