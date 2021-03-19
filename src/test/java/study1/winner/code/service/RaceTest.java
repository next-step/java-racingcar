package study1.winner.code.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RaceTest {

  @ParameterizedTest
  @CsvSource(value = {"pobi,tim:5"}, delimiter = ':')
  @DisplayName("race 시 round 가 제대로 세팅되는지 테스트")
  public void round(String participants, int round) {
    Race race = new Race(round, participants);
    List<Cars> raceRound = race.start();

    assertThat(raceRound.size()).isEqualTo(round);
  }
}
