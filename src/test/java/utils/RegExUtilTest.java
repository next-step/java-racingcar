package utils;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RegExUtils;

public class RegExUtilTest {

  @Test
  @DisplayName("[RegExUtils.extractGroup()] 문자열에서 매칭되는 정규식 그룹의 값을 조회한다.")
  public void 문자열에서_정규식_그룹_조회() {
    // given
    final String group = "group";
    final Pattern pattern = Pattern.compile(String.format("//(?<%s>[^\n])", group));
    final String input = "//;\n1;2;3";

    // when
    String 결과 = RegExUtils.extractGroup(input, pattern, group);

    // then
    assertThat(결과).isEqualTo(";");
  }

  @Test
  @DisplayName("[RegExUtils.extractGroup()] 문자열에서 매칭되는 정규식 그룹이 없으면 null을 반환한다.")
  public void 문자열에서_정규식_그룹_미존재시_null_반환() {

    // given
    final String group = "group";
    final String invalidGroup = "group not exist";
    final Pattern pattern = Pattern.compile(String.format("//(?<%s>[^\n])", group));
    final String input = "//;\n1;2;3";

    // when
    String 결과 = RegExUtils.extractGroup(input, pattern, invalidGroup);

    // then
    assertThat(결과).isNull();
  }
}
