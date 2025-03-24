package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultTest {

  private Result result;
  private Cars firstRound;
  private Cars secondRound;

  @BeforeEach
  void setUp() {
    result = new Result();
    Names names = new Names("car1,car2,car3");

    firstRound = new Cars(names);
    firstRound.getCar(0).addScore(2);
    firstRound.getCar(1).addScore(1);

    secondRound = new Cars(names);
    secondRound.getCar(0).addScore(1);
    secondRound.getCar(1).addScore(1);
    secondRound.getCar(2).addScore(1);
  }

  @Test
  void record_첫_라운드_기록() {
    result.record(0, firstRound);

    assertThat(result.size()).isEqualTo(1);
    assertThat(result.getRoundResult(0).getCar(0).getScore()).isEqualTo(2);
    assertThat(result.getRoundResult(0).getCar(1).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(0).getCar(2).getScore()).isEqualTo(0);
  }

  @Test
  void record_이전_라운드_점수_누적() {
    result.record(0, firstRound);
    result.record(1, secondRound);

    assertThat(result.getRoundResult(0).getCar(0).getScore()).isEqualTo(2);
    assertThat(result.getRoundResult(0).getCar(1).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(0).getCar(2).getScore()).isEqualTo(0);

    assertThat(result.getRoundResult(1).getCar(0).getScore()).isEqualTo(3);
    assertThat(result.getRoundResult(1).getCar(1).getScore()).isEqualTo(2);
    assertThat(result.getRoundResult(1).getCar(2).getScore()).isEqualTo(1);
  }

  @Test
  void merge_이전_라운드가_없는_경우() {
    Cars merged = result.merge(0, firstRound);

    assertThat(merged.getCar(0).getScore()).isEqualTo(2);
    assertThat(merged.getCar(1).getScore()).isEqualTo(1);
    assertThat(merged.getCar(2).getScore()).isEqualTo(0);
  }

  @Test
  void merge_이전_라운드_점수_합산() {
    result.record(0, firstRound);
    Cars merged = result.merge(1, secondRound);

    assertThat(merged.getCar(0).getScore()).isEqualTo(3);
    assertThat(merged.getCar(1).getScore()).isEqualTo(2);
    assertThat(merged.getCar(2).getScore()).isEqualTo(1);
  }
}
