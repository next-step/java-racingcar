package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

  @Test
  void testSplitMultipleItems() {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1");
    assertThat(result).contains("2");
  }

  @Test
  void testSplitSingleItem() {
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  void testSubstring() {
    String result = "(1,2)".substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("String의 charAt() 메소드는 문자열의 index가 넘어가는 값을 인자로 받으면 StringIndexOutOfBoundsException을 발생시킨다.")
  void testCharAtStringIndexOutOfBoundsException() {
    String testString = "abc";
    int targetIdx = 0;

    Random random = new Random();
    while(targetIdx <= 2) {
      targetIdx = random.nextInt(Integer.MAX_VALUE) + 1;
    }

    int finalTargetIdx = targetIdx;
    assertThatThrownBy(() -> {
      testString.charAt(finalTargetIdx);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range:");
  }
}
