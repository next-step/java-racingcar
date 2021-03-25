package step5;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step5.exception.IllegalNameLengthException;
import step5.model.Name;

public class NameTest {

  @ParameterizedTest
  @ValueSource(strings = {"      ", " ", "   "})
  @DisplayName("요소 내에서 빈 값이 입력된 경우 제대로 종료하는지 확인")
  void emptyNameTest(String testName) {
    assertThatThrownBy(() -> {
      new Name(testName);
    }).isInstanceOf(IllegalNameLengthException.class)
      .hasMessage("입력된 차량의 이름을 확인하세요. 1~5자 허용입니다. 이름: " + testName);
  }

  @ParameterizedTest
  @ValueSource(strings = {"fsdafsdf", "gsdgdsgf", "sfeqfeqrtwr", "assdfdsfg", "gregrgr", "ehgrtdhtfhfgthfgthjfgh", "asdfsdafgsdgsdgsdfg", "xbdzfbfdb", "dfhfdhfdhfdhdfas"})
  @DisplayName("5자를 초과하는 이름이 입력된 경우 제대로 종료하는지 확인")
  void invalidMaximumNameListTest(String testName) {
    assertThatThrownBy(() -> {
      new Name(testName);
    }).isInstanceOf(IllegalNameLengthException.class)
      .hasMessage("입력된 차량의 이름을 확인하세요. 1~5자 허용입니다. 이름: " + testName);
  }
}
