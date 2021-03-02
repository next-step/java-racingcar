import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// 
import static org.assertj.core.api.Assertions.*;

public class StringTest {

  @Test
  @DisplayName("'1,2' 로 split 시 1, 2로 잘 분리되는지 테스트")
  public void splitTest1() {
    String[] str = "1,2".split(",");
    assertThat(str).contains("1");
    assertThat(str).containsExactly("1", "2");
  }

  @Test
  @DisplayName("'1' 로 split 시 1만 포함하는 배열이 반환되는지 테스트")
  public void splitTest2() {
    String[] str = "1".split(",");
    assertThat(str).contains("1");
    assertThat(str).doesNotContain("2");
  }
}
