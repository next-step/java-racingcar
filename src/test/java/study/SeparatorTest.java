package study;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SeparatorTest {

  private final Separator separator = new Separator();

  @Test
  void Null_또는_빈문자() {
    String[] input = {null, ""};

    for (String s : input) {
      String[] result = separator.split(s);

      assertThat(result).hasSize(1);
      assertThat(result).containsExactly("0");
    }
  }


  @Test
  void 일반_구분자를_통해_값_추출() {
    String input = "1,2,3";

    String[] result = separator.split(input);

    assertThat(result).containsExactly("1", "2", "3");
  }

  @ParameterizedTest
  @ValueSource(strings = {"//;\n1;2;3", "//:\n1:2:3"})
  void 커스텀_구분자를_통해_값_추출(String input) {
    String[] result = separator.split(input);

    assertThat(result).containsExactly("1", "2", "3");
  }


}