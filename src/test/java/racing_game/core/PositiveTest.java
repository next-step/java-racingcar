package racing_game.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PositiveTest {

  @Test
  void create() {
    Positive pos = Positive.of(1);
    assertThat(pos.equals(1)).isTrue();
    assertThat(pos.equals(2)).isFalse();

    pos = Positive.of("1");
    assertThat(pos.equals(1)).isTrue();

    pos = Positive.zero();
    assertThat(pos.equals(0)).isTrue();
  }

  @Test
  void copy() {
    Positive pos = Positive.of(2);
    Positive copy = Positive.copy(pos);
    assertThat(pos.equals(copy)).isTrue();
    assertThat(pos).isEqualTo(copy);
  }

  @Test
  void add() {
    Positive pos = Positive.of(2);
    pos.add(2);
    assertThat(pos.equals(4)).isTrue();

    pos.addOne();
    assertThat(pos.equals(5)).isTrue();
  }
}
