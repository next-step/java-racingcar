import org.junit.jupiter.api.Test;
// 
import static org.assertj.core.api.Assertions.*;

public class StringTest {

  @Test
  public void splitTest() {
    String[] str = "1,2".split(",");
    assertThat(str).contains("1");
    assertThat(str).containsExactly("1", "2");
  }
}
