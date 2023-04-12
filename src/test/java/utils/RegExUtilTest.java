package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RegExUtils;

public class RegExUtilTest {

  @Test
  @DisplayName("[RegExUtils.extractCustomDelimiter()] 문자열에서 매칭되는 커스텀 구분자의 값을 조회한다.")
  public void 문자열에서_커스텀_구분자_조회() {
    // given
    final String input = "//;\n1;2;3";

    // when
    String 결과 = RegExUtils.extractCustomDelimiter(input);

    // then
    assertThat(결과).isEqualTo(";");
  }

  @Test
  @DisplayName("[RegExUtils.extractCustomDelimiter()] 문자열에서 매칭되는 커스텀 구분자가 없으면 null을 반환한다.")
  public void 문자열에서_커스텀_구분자_미존재시_null_반환() {

    // given
    final String input = "1;2;3";

    // when
    String 결과 = RegExUtils.extractCustomDelimiter(input);

    // then
    assertThat(결과).isNull();
  }
}
