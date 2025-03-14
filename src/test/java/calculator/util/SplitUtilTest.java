package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SplitUtilTest {
  static Stream<Arguments> provideSplitStringIntoListCases() {
    return Stream.of(
            Arguments.of("//@\n1@2@3", new String[]{"1", "2", "3"}),
            Arguments.of("//&\n2&3&4", new String[]{"2", "3", "4"}),
            Arguments.of("1>2:3", new String[]{"1>2", "3"}),
            Arguments.of("//@\n1@2<3", new String[]{"1", "2<3"}),
            Arguments.of("a",  new String[]{"a"}),
            Arguments.of("//&\na", new String[]{"a"}),
            Arguments.of("1:2:3:a", new String[]{"1", "2", "3", "a"})
    );
  }

  @ParameterizedTest
  @MethodSource("provideSplitStringIntoListCases")
  @DisplayName("커스텀 구분자 또는 : 또는 ,를 구분자로 가지는 문자열을 입력하면 구분자를 기준으로 문자열을 나눈 리스트를 반환한다.")
  void testSplitStringIntoList(String input, String[] expected) {
    String[] result = SplitUtil.splitStringIntoList(input).toArray(new String[0]);
    assertArrayEquals(expected, result);
  }
}
