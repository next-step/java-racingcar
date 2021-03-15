package study1.racing;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study1.racing.moveStrategy.TestMove;


public class RacingTest {

  @ParameterizedTest
  @CsvSource(value = { "5:3"}, delimiter = ':')
  @DisplayName("racing run 시 지정된 round, participant 에 따라 호출되는 함수 횟수 test")
  public void checkCallMethodCheckDistance(int round, int participant) {
    Race spy = spy(new Race(participant, round));
    spy.run();
    verify(spy, times(round)).checkDistance();
    verify(spy, times(round * participant)).recordDistance(anyInt());
  }

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
