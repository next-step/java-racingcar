package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositiveOrZerosTest {

  @Test
  void 생성자_정상_리스트_() {
    var inputs = Arrays.stream(new int[] {1, 2, 3}).mapToObj(PositiveOrZero::new).toList();

    assertThat(new PositiveOrZeros(inputs).values())
        .extracting(PositiveOrZero::value)
        .containsExactly(1, 2, 3);
  }

  @Test
  void 생성자_리스트_null() {
    assertThatThrownBy(() -> new PositiveOrZeros((List<PositiveOrZero>) null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("값 목록은 null일 수 없습니다");
  }

  @Test
  void 생성자_빈_리스트() {
    assertThat(new PositiveOrZeros(List.of()).values()).isEmpty();
  }

  @Test
  void 생성자_정상_문자열_배열() {
    PositiveOrZeros positiveOrZeros = new PositiveOrZeros(new String[] {"1", "2", "3"});

    assertThat(positiveOrZeros.values()).extracting(PositiveOrZero::value).containsExactly(1, 2, 3);
  }

  @Test
  void 생성자_배열_null() {
    assertThatThrownBy(() -> new PositiveOrZeros((String[]) null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("문자열 배열은 null일 수 없습니다");
  }

  @Test
  void 생성자_빈_배열() {
    assertThat(new PositiveOrZeros(new String[0]).values()).isEmpty();
  }

  @Test
  void 생성자_음수_포함_문자열_배열() {
    assertThatThrownBy(() -> new PositiveOrZeros(new String[] {"1", "-2", "3"}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -2");
  }

  @Test
  void values_불변성_보장() {
    PositiveOrZeros positiveOrZeros = new PositiveOrZeros(new String[] {"1", "2", "3"});

    assertThatThrownBy(() -> positiveOrZeros.values().add(new PositiveOrZero("1")))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void sum_정상_합산() {
    PositiveOrZeros positiveOrZeros = new PositiveOrZeros(new String[] {"1", "2", "3"});

    assertThat(positiveOrZeros.sum()).isEqualTo(6);
  }

  @Test
  void sum_단일_요소() {
    PositiveOrZeros positiveOrZeros = new PositiveOrZeros(new String[] {"5"});

    assertThat(positiveOrZeros.sum()).isEqualTo(5);
  }

  @Test
  void sum_0_포함() {
    PositiveOrZeros positiveOrZeros = new PositiveOrZeros(new String[] {"0", "1", "2"});

    assertThat(positiveOrZeros.sum()).isEqualTo(3);
  }

  @Test
  void sum_빈_배열() {
    assertThat(new PositiveOrZeros(List.of()).sum()).isEqualTo(0);
  }
}
