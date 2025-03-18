package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarRacingJudgeTest {

  @DisplayName("자동차 경주의 우승자를 구하는 기능 테스트")
  @Test
  void testGetWinners() {
    List<Car> cars = CarFactory.createCars(
            List.of("pobi", "crong", "honux")
    );
    cars.get(0).move(4);
    cars.get(0).move(4);
    cars.get(1).move(4);
    cars.get(1).move(4);
    cars.get(2).move(1);
    cars.get(2).move(4);

    List<Car> expected = List.of(cars.get(0), cars.get(1));
    List<Car> actual = CarRacingJudge.judgeWinners(cars);

    Assertions.assertEquals(expected, actual);
  }
}