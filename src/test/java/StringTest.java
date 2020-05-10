import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

  @Test
  void split () {
    String[] res = "1,2".split(",");
    assertThat(res).contains("1", "2");
    assertThat(res).containsExactly("1", "2");
  }
}
