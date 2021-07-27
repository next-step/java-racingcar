package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

  private Result result;

  @BeforeEach
  void init() {
    result = new Result(
        List.of(
            new Car(new Name("pobi"), 5),
            new Car(new Name("crong"), 3),
            new Car(new Name("honux"), 5)
        )
    );
  }

  @DisplayName("우승자는 두명이며, pobi와 honux이다")
  @Test
  void winners() {

    final List<String> actual = result.getWinners();
    assertThat(actual).hasSize(2)
        .containsExactly("pobi", "honux");

  }
}