package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("#요구사항1 - 집합 분리 테스트(1)")
  void split_one_and_two() {

    String[] result = "1,2".split(",");

    assertThat(result).containsExactly("1", "2");
    assertThat(result).contains("1","2");

  }

  @Test
  @DisplayName("#요구사항1 - 집합 분리 테스트(2)")
  void split_one() {

    String[] result2 = "1".split(",");
    assertThat(result2).containsExactly("1");

  }

  @Test
  @DisplayName("#요구사항2 - 괄호 제거")
  void delete_괄호() {

    String input = "(1,2)";
    assertThat(input.substring(1,4)).isEqualTo("1,2");

  }

  @Test
  @DisplayName("#요구사항3 -잘못된 인덱스 가져오기")
  void 인덱스_가져오기() {

    String input = "a,b,c";
    int index = 10;

    assertThatThrownBy(() -> {
      input.charAt(index);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
