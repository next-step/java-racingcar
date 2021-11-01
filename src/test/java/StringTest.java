import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
  @Test
  @DisplayName("String.split()")
  public void testStringSplit() {
    assertThat("1,2".split(",")).hasSize(2).contains("1").contains("2");
    assertThat("1".split(",")).hasSize(1).contains("1");
  }

  @Test
  @DisplayName("String.substring()")
  public void testSubstring() {
    assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
  }

  @Test
  @DisplayName("String.charAt()")
  public void testCharAt() {
    String abc = "abc";
    assertThat(abc.charAt(0)).isEqualTo('a');
    assertThat(abc.charAt(1)).isEqualTo('b');
    assertThat(abc.charAt(2)).isEqualTo('c');
    assertThatThrownBy(() -> {
      abc.charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
