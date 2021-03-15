package study.racing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberConditionMoveStrategyTest {

  @ParameterizedTest
  @CsvSource(value = {"1,false", "2,false", "4,true", "5,true"})
  @DisplayName("전진전략 테스트, 4이상 일시에만 true")
  void isMove(int number, boolean result) {
    NumberConditionMoveStrategy strategy = new NumberConditionMoveStrategy();
    boolean move = strategy.isMove(number);
    assertEquals(move, result);
  }
}
