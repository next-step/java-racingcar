package caculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositiveOrZerosTest {

  @Test
  void 생성자_null() {
    assertThatThrownBy(() -> new PositiveOrZeros(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("양수 목록은 null일 수 없습니다.");
  }

  @Test
  void 생성자_빈_리스트() {
    assertThatThrownBy(() -> new PositiveOrZeros(List.of()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("양수 목록은 비어있을 수 없습니다.");
  }

  @Test
  void from_정상_문자열_배열() {
    PositiveOrZeros positiveOrZeros = PositiveOrZeros.from(new String[] {"1", "2", "3"});

    assertThat(positiveOrZeros.values()).extracting(PositiveOrZero::value).containsExactly(1, 2, 3);
  }

  @Test
  void from_음수_포함_문자열_배열() {
    assertThatThrownBy(() -> PositiveOrZeros.from(new String[] {"1", "-2", "3"}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -2");
  }

  @Test
  void from_null() {
    assertThatThrownBy(() -> PositiveOrZeros.from(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("문자열 배열은 null일 수 없습니다.");
  }

  @Test
  void from_빈_배열() {
    assertThatThrownBy(() -> PositiveOrZeros.from(new String[0]))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("양수 목록은 비어있을 수 없습니다.");
  }

  @Test
  void values_불변성_보장() {
    PositiveOrZeros positiveOrZeros = PositiveOrZeros.from(new String[] {"1", "2", "3"});

    assertThatThrownBy(() -> positiveOrZeros.values().add(new PositiveOrZero("1")))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void sum_정상_합산() {
    PositiveOrZeros positiveOrZeros = PositiveOrZeros.from(new String[] {"1", "2", "3"});

    assertThat(positiveOrZeros.sum()).isEqualTo(6);
  }

  @Test
  void sum_단일_요소() {
    PositiveOrZeros positiveOrZeros = PositiveOrZeros.from(new String[] {"5"});

    assertThat(positiveOrZeros.sum()).isEqualTo(5);
  }

  @Test
  void sum_0_포함() {
    PositiveOrZeros positiveOrZeros = PositiveOrZeros.from(new String[] {"0", "1", "2"});

    assertThat(positiveOrZeros.sum()).isEqualTo(3);
  }
}
