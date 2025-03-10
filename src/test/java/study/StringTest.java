package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("요구사항1: split 함수는 delimiter를 기준으로 문자열을 분리한다")
  void split_based_on_delimiter() {
    String given = "1,2";
    String[] when = given.split(",");

    assertThat(when).containsExactly("1", "2");
  }

  @Test
  @DisplayName("요구사항1: split 함수는 분리할 것이 없어도 정상적으로 동작한다")
  void split_with_no_delimiter() {
    String given = "1";
    String[] when = given.split(",");

    assertThat(when).containsExactly("1");
  }

  @Test
  @DisplayName("요구사항2: substring 함수는 문자열에서 시작 인덱스부터 끝 인덱스 전까지의 부분 문자열을 반환한다")
  void substring_with_start_and_end_index() {
    String given = "(1,2)";
    String value = given.substring(1, given.length() - 1);
    assertThat(value).isEqualTo("1,2");
  }

  @Test
  @DisplayName("요구사항3: charAt 함수는 특정 위치의 문자를 반환한다")
  void charAt_returns_character_at_index() {
    String given = "abc";
    char when = given.charAt(1);
    assertThat(when).isEqualTo('b');
  }

  @Test
  @DisplayName("요구사항3: charAt 함수는 문자열보다 큰 인덱스를 지정하면 StringIndexOutOfBoundsException을 발생시킨다")
  void charAt_throws_exception_on_invalid_index() {
    String given = "abc";
    assertThatThrownBy(() -> {
      given.charAt(given.charAt(given.length() + 1));
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range");
  }
}
