package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarRacingJudgeTest {

  @DisplayName("자동차 경주의 우승자를 구하는 기능 테스트")
  @Test
  void testJudgeWinners() {
    Cars cars = new Cars(List.of(new Car(0, "pobi", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy()), new Car(1, "crong", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy()), new Car(2, "honux", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy())));

    Cars expected = new Cars(List.of(new Car("honux", new CarMoveStrategyTest.TestAlwaysCarMoveStrategy())));
    Cars actual = CarRacingJudge.judgeWinners(cars);

    Assertions.assertEquals(expected, actual);
  }
}