package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

  private final Converter converter = new Converter();

  @Test
  void 숫자를_문자열로_변환() {
    String[] input = {"1", "2", "3"};

    PositiveNumber numbers = converter.convert(input);

    assertThat(numbers.size()).isEqualTo(3);
    assertThat(numbers.values()).containsExactly(1, 2, 3);
  }

  @Test
  void 음수숫자_예외_처리() {
    String[] input = {"-1", "2", "3"};

    assertThatThrownBy(() -> converter.convert(input))
        .isInstanceOf(RuntimeException.class);
  }
}