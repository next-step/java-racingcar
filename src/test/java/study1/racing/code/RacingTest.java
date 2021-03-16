package study1.racing.code;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import study1.racing.code.moveStrategy.RaceMove;

public class RacingTest {

  @RepeatedTest(value = 100, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  @DisplayName("ramdom 으로 값 생성 반복 확인 0 or 1")
  public void checkMoveDistance(RepetitionInfo repetitionInfo) {
    Car car = new Car();
    int moved = car.move(new RaceMove());
    assertThat(moved).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(1);
  }

  @ParameterizedTest
  @CsvSource(value= {"1:2", "3:4"}, delimiter = ':')
  @DisplayName("move 시 현재 값보다 1 더한값이 return 되는지 테스트")
  public void checkMoveDistanceOnlyFixedNumber(int initDistance, int result) {
    Car car = new Car(initDistance);
    int moved = car.move(() -> true);
    assertThat(moved).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"5:3"}, delimiter = ':')
  @DisplayName("round 와 participant 가 지정되었을때 반환되는 RaceRound size 와 RaceRound 안에 car 사이즈 체크")
  public void checkStart(int participant, int round) {
    Race race = new Race(participant, round);
    List<RaceRound> rounds = race.start();
    assertThat(rounds.size()).isEqualTo(round);
    for(RaceRound raceRound : rounds) {
      assertThat(raceRound.getResult().size()).isEqualTo(participant);
    } 
  }
}
