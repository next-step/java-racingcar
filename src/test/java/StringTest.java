import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {
    assertThat("1,2".split(",")).containsExactly("1", "2");
  }

  @Test
  void substring() {
    assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
  }

  @DisplayName("잘못된 인덱스로 charAt()을 실행했을 때, IndexOutOfBoundsException이 발생하는가 확인한다.")
  @Test
  public void charAt() {
    assertThatThrownBy(() -> "abc".charAt(10))
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining(String.format("String index out of range: %s", 10));
  }
}
