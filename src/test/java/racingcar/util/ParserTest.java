package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

  @Test
  public void 차이름분리테스트() {
    String inputCarName = "name1,name2,name3";
    assertThat(Parser.parseCarNames(inputCarName)).containsExactly("name1", "name2", "name3");
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", " ", "   "})
  public void null_공백_테스트(String input) {
    AssertionsForClassTypes.assertThatThrownBy(() -> {
      Parser.parseCarNames(input);
    }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("자동차명을 입력하세요");
  }

}