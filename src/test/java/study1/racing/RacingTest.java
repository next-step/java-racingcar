package study1.racing;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import study1.racing.moveStrategy.TestMove;


public class RacingTest {

  @RepeatedTest(value = 100, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  @DisplayName("ramdom 으로 값 생성 반복 확인 0 or 1")
  public void checkMoveDistance(RepetitionInfo repetitionInfo) {
    Car car = new Car();
    int moved = car.move();
    assertThat(moved).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
  }

  @RepeatedTest(value = 100, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  @DisplayName("test move 시 1 만 return 되는지 테스트")
  public void checkMoveDistanceOnlyFixedNumber() {
    Car car = new Car();
    car.setMoveStrategy(new TestMove());
    int moved = car.move();
    assertThat(moved).isEqualTo(1);
  }
}
