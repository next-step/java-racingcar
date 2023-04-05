package learningTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MatcherTest {

  @Test
  @DisplayName("Matcher의 group 메서드는 정규식에 매칭된 문자열 그룹을 추출할 수 있다")
  void groupTest() {
    // given
    String input = "//;\n1;2;3";

    // when
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
    matcher.find();
    String customDelimiter = matcher.group(1);
    String[] splitInput = matcher.group(2).split(customDelimiter);

    // then
    assertThat(splitInput).containsExactlyInAnyOrder("1", "2", "3");
  }
}
