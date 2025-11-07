package caculator;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TokensTest {

  @Test
  void 생성자_null() {
    assertThatThrownBy(() -> new Tokens(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("토큰 목록은 null일 수 없습니다.");
  }

  @Test
  void 생성자_빈_리스트() {
    assertThatThrownBy(() -> new Tokens(List.of()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("토큰 목록은 비어있을 수 없습니다.");
  }

  @Test
  void from_정상_문자열_배열() {
    Tokens tokens = Tokens.from(new String[] {"1", "2", "3"});

    assertThat(tokens.values()).extracting(Positive::value).containsExactly(1, 2, 3);
  }

  @Test
  void from_null() {
    assertThatThrownBy(() -> Tokens.from(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("토큰 배열은 null일 수 없습니다.");
  }

  @Test
  void from_빈_배열() {
    assertThatThrownBy(() -> Tokens.from(new String[0]))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("토큰 목록은 비어있을 수 없습니다.");
  }

  @Test
  void values_불변성_보장() {
    Tokens tokens = Tokens.from(new String[] {"1", "2", "3"});

    assertThatThrownBy(() -> tokens.values().add(Positive.from("1")))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Test
  void toIntArray_모든_요소가_양수() {
    int[] result = Tokens.from(new String[] {"1", "2", "3"}).toIntArray();

    assertThat(result).containsExactly(1, 2, 3);
  }

  @Test
  void toIntArray_음수가_포함() {
    assertThatThrownBy(() -> Tokens.from(new String[] {"1", "-2", "3"}))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -2");
  }
}
