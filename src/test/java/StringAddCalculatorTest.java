import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

  @Test
  public void split_쉼표구분자() throws Exception {

    String[] result = "1,2".split(",");
    assertThat(result).contains("1","2");
  }

  @Test
  public void split_숫자하나() throws Exception {
    String[] result = "1".split(",");
    assertThat(result).contains("1");
  }

  @Test
  public void clear_괄호() throws Exception {
    String clear = "(1,2)".substring(1, 4);
    assertThat(clear).isEqualTo("1,2");
  }

  @Test
  public void find_특정위치문자() throws Exception {
    String find = "(1,2)";
    assertThat(find.charAt(1)).isEqualTo('1');
  }

  @Test
  @DisplayName("특정 위치 문자 삭제")
  public void find_특정위치문자_throw_exception() throws Exception {
    String find = "(1,2)";
    assertThatThrownBy(() -> {
      find.charAt(find.length());
    }).isInstanceOf(Exception.class);
  }
}