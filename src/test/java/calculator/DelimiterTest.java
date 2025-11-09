package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DelimiterTest {

  @Test
  void parse_기본구분자_쉼표() {
    Delimiter delimiter = Delimiter.parse("1,2,3");
    assertThat(delimiter.split()).containsExactly("1", "2", "3");
  }

  @Test
  void parse_기본구분자_콜론() {
    Delimiter delimiter = Delimiter.parse("1:2:3");
    assertThat(delimiter.split()).containsExactly("1", "2", "3");
  }

  @Test
  void parse_기본구분자_혼합() {
    Delimiter delimiter = Delimiter.parse("1,2:3");
    assertThat(delimiter.split()).containsExactly("1", "2", "3");
  }

  @Test
  void parse_커스텀구분자() {
    Delimiter delimiter = Delimiter.parse("//;\n1;2;3");
    assertThat(delimiter.split()).containsExactly("1", "2", "3");
  }
}