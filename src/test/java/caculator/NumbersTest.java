package caculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NumbersTest {

  @Test
  void 생성자_null() {
    assertThatThrownBy(() -> new Numbers(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("숫자 리스트가 null입니다.");
  }

  @Test
  void 생성자_빈리스트() {
    assertThatThrownBy(() -> new Numbers(List.of()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자 리스트가 비어있습니다.");
  }

  @Test
  void from_int_배열() {
    Numbers numbers = Numbers.from(new int[] {1, 2, 3});

    assertThat(numbers.values()).containsExactly(1, 2, 3);
  }

  @Test
  void from_null() {
    assertThatThrownBy(() -> Numbers.from(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("숫자 배열이 null입니다.");
  }

  @Test
  void values_불변성_보장() {
    Numbers numbers = Numbers.from(new int[] {1, 2, 3});
    assertThatThrownBy(() -> numbers.values().add(4))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void sum_리스트의_모든_요소_합을_반환() {
    Numbers numbers = Numbers.from(new int[] {1, 2, 3});
    assertThat(numbers.sum()).isEqualTo(6);
  }
}
