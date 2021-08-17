package step45.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

  @Test
  void isBlankTest() {
    //given
    String nullStr = null;
    String emptyStr = "";
    String validStr = "hello";

    //when
    boolean actual1 = StringUtils.isBlank(nullStr);
    boolean actual2 = StringUtils.isBlank(emptyStr);
    boolean actual3 = StringUtils.isBlank(validStr);

    //then
    assertThat(actual1).isEqualTo(true);
    assertThat(actual2).isEqualTo(true);
    assertThat(actual3).isEqualTo(false);
  }
}