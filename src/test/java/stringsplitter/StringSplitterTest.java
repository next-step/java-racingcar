package stringsplitter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//String 클래스에 대한 학습 테스트
public class StringSplitterTest {

  //요구사항 1
  @DisplayName("Verify the feature of splitting the string `String '1,2'` according to the spliter `:`")
  @Test
  void splitStringTestToHaveTwoElements() {
    assertThat("1,2".split(",")).contains("1");
    assertThat("1,2".split(",")).contains("2");
    assertThat("1,2".split(",")).contains("1", "2");
    assertThat("1,2".split(",")).containsExactly("1", "2");
  }

  @DisplayName("Verify the feature of splitting the string `1` to have only one substance `1` in list")
  @Test
  void splitStringTestToHaveOneElement() {
    assertThat("1".split(",")).contains("1");
    assertThat("1".split(",")).containsExactly("1");
  }

  //요구사항 2
  @DisplayName("Return `1,2` by trimming brackets from (1,2) utilizing substring method()")
  @Test
  void trimBracketsFromString() {
    assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
  }

  //요구사항 3-1
  @DisplayName("Claiming the index of specific character when `abc` is given, utilizing charAt() method from String")
  @Test
  void claimingCharacterIndexFromGivenString() {
    assertThat("abc".charAt(0)).isEqualTo('a');
    assertThat("abc".charAt(1)).isEqualTo('b');
    assertThat("abc".charAt(2)).isEqualTo('c');
  }
}
