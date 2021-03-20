package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static base.BaseMethodSource.BLANK_STRINGS;
import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

  @ParameterizedTest
  @ValueSource(strings = {"string1, string2"})
  @DisplayName("split 테스트")
  void split(String str) {
    // given

    // when
    String[] result = StringUtils.split(str);

    // then
    assertThat(result).hasSize(2);
  }

  @ParameterizedTest
  @ValueSource(strings = {"string1, string2"})
  @DisplayName("문자열 List 변환")
  void toList(String str) {
    // given

    // when
    List<String> result = StringUtils.toList(str);

    // then
    assertThat(result)
            .contains(StringUtils.split(str))
            .hasSize(2);
  }

  @ParameterizedTest
  @MethodSource(BLANK_STRINGS)
  @DisplayName("공백 or null 문자열 \"\" 빈 공백 문자열로 반환")
  void defaultString(String blankStr) {
    // given

    // when
    String result = StringUtils.defaultString(blankStr);

    // then
    assertThat(result).isEqualTo("");
  }
}