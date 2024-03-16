package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.step4.domain.strategy.RandomCarMoveStrategy;
import racingcar.step4.domain.strategy.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCarMoveStrategyTest {

  private final RandomCarMoveStrategy randomCarMoveStrategy = new RandomCarMoveStrategy();

  @ParameterizedTest
  @CsvSource(value = {"0:false", "1:false", "2:false", "3:false"}, delimiter = ':')
  @DisplayName("0 ~ 3의 경우 전진하지 않는지 테스트")
  void isMovableTest2(int given, boolean expected) {
    assertThat(randomCarMoveStrategy.isMovable(bound -> given)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
  @DisplayName("4 ~ 9의 경우 전진하는지 테스트")
  void isMovableTest3(int given, boolean expected) {
    assertThat(randomCarMoveStrategy.isMovable(bound -> given)).isEqualTo(expected);
  }
}
