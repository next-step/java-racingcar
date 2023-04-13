package study.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TextSplitTest {

  @DisplayName("null을 split하면 NullPointExeption이 발생한다.")
  @Test
  public void split_throwsExeption_null() {
    assertThatThrownBy(() -> TextSpliter.split(null))
        .isInstanceOf(NullPointerException.class);
  }

  @DisplayName("빈 문자열을 split하면 빈문자열이 들어간 배열을 반환한다.")
  @Test
  public void split_stringArr_emptyString() {
    assertThat(TextSpliter.split("")).contains("");
  }

  @DisplayName("하나의 숫자문자열을 split하면 해당 숫자가 들어간 배열을 반환한다.")
  @Test
  public void split_stringArr_OneNumber() {
    assertThat(TextSpliter.split("1")).contains("1");
  }

  @DisplayName("쉼표로 구분된 숫자 문자열을 split하면 해당 숫자들의 배열을 반환한다.")
  @Test
  public void split_stringArr_쉼표Delimeters() {
    assertThat(TextSpliter.split("1,2")).containsExactly("1", "2");
  }

  @DisplayName("콜론로 구분된 숫자 문자열을 split하면 해당 숫자들의 배열을 반환한다.")
  @Test
  public void split_stringArr_콜론Delimeters() {
    assertThat(TextSpliter.split("1:2")).containsExactly("1", "2");
  }

  @DisplayName("쉼표와 콜론으로 구분된 숫자 문자열을 split하면 해당 숫자들의 배열을 반환한다.")
  @Test
  public void split_stringArr_쉼표콜론Delimeters() {
    assertThat(TextSpliter.split("1,2:3")).containsExactly("1", "2", "3");
  }

  @DisplayName("custum구분자가 포함된 숫자 문자열을 split하면 해당 숫자들의 배열을 반환한다.")
  @Test
  public void split_stringArr_CustomDelimeters() {
    assertThat(TextSpliter.split("//;\n1;2;3")).containsExactly("1", "2", "3");
    assertThat(TextSpliter.split("//'\n1'2'3")).containsExactly("1", "2", "3");
  }
}
