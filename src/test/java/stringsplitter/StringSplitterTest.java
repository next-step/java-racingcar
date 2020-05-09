package stringsplitter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitterTest {

  @DisplayName("Verify the feature of splitting the string `String '1,2'` according to the spliter `:`")
  @Test
  void splitStringTestToHaveTwoElements() {
    assertThat("1,2".split(",")).containsExactly("1", "2");
  }

  @DisplayName("Verify the feature of splitting the string `1` to have only one substance `1` in list")
  @Test
  void splitStringTestToHaveOneElement() {
    assertThat("1".split(",")).containsExactly("1");
  }
}
