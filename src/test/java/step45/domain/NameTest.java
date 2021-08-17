package step45.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    String testName = "test";

    //when
    Name name = new Name(testName);
    String actual = name.getName();

    //then
    assertThat(actual).isEqualTo(testName);
  }

  @Test
  @DisplayName("잘못된 이름 테스트")
  void invalidNameTest() {
    //given
    List<String> invalidNames = Arrays.asList(null, "", "123456");

    //then
    for (String invalidName : invalidNames) {
      assertThatIllegalArgumentException().isThrownBy(() -> new Name(invalidName));
    }
  }
}