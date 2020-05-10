import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

  @Test
  void split1 () {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1", "2");
  }

  @Test
  void split2 () {
    String input = "(1,2)";
    String result = input.substring(1, input.length() - 1);
    assertThat(result).contains("1,2");
  }
}
