package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SplitUtilTest {

  @Test
  void splitToListByDefaultDelimiter() {
    List<String> result = SplitUtil.splitToList("pobi,crong,honux");
    assertThat(result).hasSize(3);
  }

  @Test
  void testSplitToList() {
    List<String> result = SplitUtil.splitToList("pobi:crong:honux", ":");
    assertThat(result).hasSize(3);
  }
}
