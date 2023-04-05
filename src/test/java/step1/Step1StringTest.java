package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StringUtils;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class Step1StringTest {

  public static final String SEPARATOR = ",";

  @Test
  @DisplayName("[단계 1 String 요구사항 1.1] '1,2'를 split 했을 때 1과 2로 분리된다.")
  void 단계_1_String_요구사항_1_1() {
    final String[] 예상결과 = {"1", "2"};

    // given
    final String input = "1,2";

    // when
    final String[] 결과 = input.split(SEPARATOR);

    // then
    Assertions.assertArrayEquals(예상결과, 결과);
  }

  @Test
  @DisplayName("[단계 1 String 요구사항 1.2] '1'를 split 했을 때는 1만을 포함하는 배열을 반환한다.")
  void 단계_1_String_요구사항_1_2() {
    final String[] 예상결과 = {"1"};

    // given
    final String input = "1";

    // when
    final String[] 결과 = input.split(SEPARATOR);

    // then
    Assertions.assertArrayEquals(예상결과, 결과);
  }

  @Test
  @DisplayName("[단계 1 String 요구사항 2.1] '(1,2)' 값이 주어졌을 때 ()를 제거하고 '1,2'를 반환하도록 구현한다.")
  void 단계_1_String_요구사항_2_1() {
    final String 예상결과 = "1,2";

    // given
    final String input = "(1,2)";

    // when
    final String 결과 = StringUtils.removalParentheses(input);

    // then
    Assertions.assertEquals(예상결과, 결과);
  }

  @Test
  @DisplayName("[단계 1 String 요구사항 3.1] 'abc' 값이 주어졌을 때 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
  void 단계_1_String_요구사항_3_1() {
    final char 예상결과 = 'a';

    // given
    final String input = "abc";

    // when
    final char 결과 = input.charAt(0);

    // then
    Assertions.assertEquals(예상결과, 결과);
  }

  @Test
  @DisplayName("단계 1 String [요구사항 3.2] 'abc' 값이 주어졌을 때 위치를 벗어난 문자를 가져 올 수 없다.")
  void 단계_1_String_요구사항_3_2() {
    final char 예상결과 = 'a';
    final int 범위를_벗어난_위치 = 99999;

    // given
    final String input = "abc";

    // when & then
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> input.charAt(범위를_벗어난_위치))
        .withMessageMatching("String index out of range: \\d+");
  }
}
