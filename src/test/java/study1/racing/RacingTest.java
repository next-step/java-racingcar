package study1.racing;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class RacingTest {

  @ParameterizedTest
  @CsvSource(value = { "5:3"}, delimiter = ':')
  @DisplayName("racing run 시 지정된 round, participant 에 따라 호출되는 함수 횟수 test")
  void checkCallMethodCheckDistance(int round, int participant) {
    Race spy = spy(new Race(participant, round));
    spy.run();
    verify(spy, times(round)).checkDistance();
    verify(spy, times(round * participant)).recordDistance(anyInt());
  }
}
