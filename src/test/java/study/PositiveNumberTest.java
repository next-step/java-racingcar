package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositiveNumberTest {

  @Test
  void constructor() {
    assertThatThrownBy(() -> new PositiveNumber(new int[]{-1, 2, 3}))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void sum() {
    PositiveNumber positiveNumber = new PositiveNumber(new int[]{1, 2, 3});

    int sum = positiveNumber.sum();

    assertThat(sum).isEqualTo(6);
  }

  @Test
  void size() {
    PositiveNumber positiveNumber = new PositiveNumber(new int[]{1, 2, 3});

    int size = positiveNumber.size();

    assertThat(size).isEqualTo(3);
  }

  @Test
  void values() {
    PositiveNumber positiveNumber = new PositiveNumber(new int[]{1, 2, 3});

    int[] values = positiveNumber.values();

    assertThat(values).containsExactly(1, 2, 3);
  }

  @Test
  void validateNonNegative_Throw_Exception() {
    int[] input = {-1, 2, 3};

    assertThatThrownBy(() -> new PositiveNumber(input))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void validateNonNegative_Does_Not_Throw_Exception() {
    int[] input = {1, 2, 3};

    assertThatCode(() -> new PositiveNumber(input))
        .doesNotThrowAnyException();
  }
}