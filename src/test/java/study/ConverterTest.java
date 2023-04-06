package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

  private final Converter converter = new Converter();

  @Test
  void 숫자를_문자열로_변환() {
    String[] input = {"1", "2", "3"};

    int[] nums = converter.convert(input);

    assertThat(nums).hasSize(3);
    assertThat(nums).containsExactly(1, 2, 3);
  }

  @Test
  void 음수숫자_예외_처리() {
    String[] input = {"-1", "2", "3"};

    assertThatThrownBy(() -> converter.convert(input))
        .isInstanceOf(RuntimeException.class);
  }
}