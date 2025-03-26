package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ResultTest {

  private Result result;
  private Cars firstRound;
  private Cars secondRound;

  @BeforeEach
  void setUp() {
    result = new Result();
    Names names = new Names(new String[]{"car1", "car2", "car3"});

    firstRound = new Cars(names);
    firstRound.at(0).addScore(2);
    firstRound.at(1).addScore(1);

    secondRound = new Cars(names);
    secondRound.at(0).addScore(1);
    secondRound.at(1).addScore(1);
    secondRound.at(2).addScore(1);
  }

  @Test
  void record_첫_라운드_기록() {
    result.record(0, firstRound);

    Cars expected = new Cars(
        List.of(
            new Car("car1", 2),
            new Car("car2", 1),
            new Car("car3", 0)
        )
    );
    assertThat(result.getRoundResult(0)).isEqualTo(expected);
  }

  @Test
  void record_이전_라운드_점수_누적() {
    result.record(0, firstRound);
    result.record(1, secondRound);

    Cars expectedFirstRound = new Cars(
        List.of(
            new Car("car1", 2),
            new Car("car2", 1),
            new Car("car3", 0)
        )
    );
    Cars expectedSecondRound = new Cars(
        List.of(
            new Car("car1", 3),
            new Car("car2", 2),
            new Car("car3", 1)
        )
    );

    assertAll(
        () -> assertThat(result.getRoundResult(0)).isEqualTo(expectedFirstRound),
        () -> assertThat(result.getRoundResult(1)).isEqualTo(expectedSecondRound)
    );
  }

  @Test
  void merge_이전_라운드가_없는_경우() {
    Cars merged = result.merge(0, firstRound);

    Cars expected = new Cars(
        List.of(
            new Car("car1", 2),
            new Car("car2", 1),
            new Car("car3", 0)
        )
    );
    assertThat(merged).isEqualTo(expected);
  }

  @Test
  void merge_이전_라운드_점수_합산() {
    result.record(0, firstRound);
    Cars merged = result.merge(1, secondRound);

    Cars expected = new Cars(
        List.of(
            new Car("car1", 3),
            new Car("car2", 2),
            new Car("car3", 1)
        )
    );
    assertThat(merged).isEqualTo(expected);
  }
}
