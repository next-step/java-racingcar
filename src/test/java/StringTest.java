import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("1,2를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void splitTest() {
        // given
        String str = "1,2";

        // when
        String[] sut = str.split(",");

        // then
        assertAll(() -> assertThat(sut).contains("1", "2"), () -> assertThat(sut).containsExactly("1", "2"));
    }

    @DisplayName("(1,2) 값이 주어졌을 때 substring 활용해 괄호를 제거 한다.")
    @Test
    void substringTest() {
        // given
        String str = "(1,2)";

        // when
        String sut = str.substring(1, str.length() - 1);

        // then
        assertThat(sut).isEqualTo("1,2");
    }
}
