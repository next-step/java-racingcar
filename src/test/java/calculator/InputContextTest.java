package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InputContextTest {

  @Test
  void parse_기본구분자_쉼표() {
    InputContext inputContext = InputContext.parse("1,2,3");
    assertThat(inputContext.split()).containsExactly("1", "2", "3");
  }

  @Test
  void parse_기본구분자_콜론() {
    InputContext inputContext = InputContext.parse("1:2:3");
    assertThat(inputContext.split()).containsExactly("1", "2", "3");
  }

  @Test
  void parse_기본구분자_혼합() {
    InputContext inputContext = InputContext.parse("1,2:3");
    assertThat(inputContext.split()).containsExactly("1", "2", "3");
  }

  @Test
  void parse_커스텀구분자() {
    InputContext inputContext = InputContext.parse("//;\n1;2;3");
    assertThat(inputContext.split()).containsExactly("1", "2", "3");
  }
}