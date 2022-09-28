import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokenizerTest {

  @Test
  @DisplayName("커스텀 패턴의 String 을 조건에 맞게 토큰화 확인")
  void tokenize_custom() {
    String target = "//;\n1;2;3";
    String[] tokens = Tokenizer.tokenize(target);
    assertThat(tokens).contains("1", "2", "3");
  }

  @Test
  @DisplayName("기본 패턴의 String 을 조건에 맞게 토큰화 확인")
  void tokenize_base() {
    String target = "1:2:3,4";
    String[] tokens = Tokenizer.tokenize(target);
    assertThat(tokens).contains("1", "2", "3", "4");
  }
}
