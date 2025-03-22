package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarRacingJudgeTest {

  @DisplayName("자동차 경주의 우승자를 구하는 기능 테스트")
  @Test
  void testJudgeWinners() {
    List<Car> cars = List.of(
            new Car(1, "pobi", new CarMoveStrategyTest.TestStoppedCarMoveStrategy()),
            new Car(2, "crong", new CarMoveStrategyTest.TestStoppedCarMoveStrategy()),
            new Car(3, "honux", new CarMoveStrategyTest.TestStoppedCarMoveStrategy())
    );

    List<Car> expected = List.of(cars.get(2));
    List<Car> actual = CarRacingJudge.judgeWinners(cars);

    Assertions.assertEquals(expected, actual);
  }
}