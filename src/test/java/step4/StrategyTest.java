package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.strategy.CarMovingStrategy;
import step4.strategy.Strategy;
import step4.util.Generator;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

  Strategy strategy;

  private Generator staticGenerator(int num){
    return () -> num;
  }

  @ParameterizedTest
  @DisplayName("4 이상의 값이 입력됐을 시 정상적으로 OK 싸인을 보내는지 확인")
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void moveOkTest(int randomValue) {
    strategy = new CarMovingStrategy(staticGenerator(randomValue));
    assertThat(strategy.isMovable()).isEqualTo(true);
  }

  @ParameterizedTest
  @DisplayName("3 이하의 값이 입력됐을 시 Fail 싸인을 보내는지 확인")
  @ValueSource(ints = {0, 1, 2, 3})
  void moveFailTest(int randomValue) {
    strategy = new CarMovingStrategy(staticGenerator(randomValue));
    assertThat(strategy.isMovable()).isEqualTo(false);
  }

}