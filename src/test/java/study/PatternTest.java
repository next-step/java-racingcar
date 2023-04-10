package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class PatternTest {

  @Test
  void PatternMatcher테스트() {
    String text = "//#\n1#2#3";
    String customDelimiter = null;
    String token = null;

    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (m.find()) {
      customDelimiter = m.group(1);
      token = m.group(2);
    }

    assertThat(customDelimiter).isEqualTo("#");
    assertThat(token).isEqualTo("1#2#3");
  }

}
