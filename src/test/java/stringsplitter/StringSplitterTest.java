package stringsplitter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitterTest {

  @DisplayName("Verify the feature of splitting the string `String '1,2'` according to the spliter `:`")
  @Test
  void splitStringTest() {
    assertThat("1,2".split(",")).containsExactly("1", "2");
  }
}
