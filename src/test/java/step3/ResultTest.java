package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultTest {

  private Result result;
  private Car[] firstRound;
  private Car[] secondRound;

  @BeforeEach
  void setUp() {
    result = new Result();

    firstRound = new Car[3];
    firstRound[0] = new Car();
    firstRound[0].addScore(2);
    firstRound[1] = new Car();
    firstRound[1].addScore(1);
    firstRound[2] = new Car();

    secondRound = new Car[3];
    secondRound[0] = new Car();
    secondRound[0].addScore(1);
    secondRound[1] = new Car();
    secondRound[1].addScore(1);
    secondRound[2] = new Car();
    secondRound[2].addScore(1);
  }

  @Test
  void record_첫_라운드_기록() {
    result.record(0, firstRound);

    assertThat(result.size()).isEqualTo(1);
    assertThat(result.get(0)).extracting("score")
        .containsExactly(2, 1, 0);
  }

  @Test
  void record_이전_라운드_점수_누적() {
    result.record(0, firstRound);
    result.record(1, secondRound);

    assertThat(result.get(0)).extracting("score")
        .containsExactly(2, 1, 0);
    assertThat(result.get(1)).extracting("score")
        .containsExactly(3, 2, 1);
  }

  @Test
  void merge_이전_라운드가_없는_경우() {
    Car[] merged = result.merge(0, firstRound);

    assertThat(merged).extracting("score")
        .containsExactly(2, 1, 0);
  }

  @Test
  void merge_이전_라운드_점수_합산() {
    result.record(0, firstRound);
    Car[] merged = result.merge(1, secondRound);

    assertThat(merged).extracting("score")
        .containsExactly(3, 2, 1);
  }
}
