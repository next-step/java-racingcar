package camp.nextstep.edu.rebellion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {
    @DisplayName("1,2 문자열을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    @Test
    public void splitTest() {
        // given
        String str = "1,2";

        // when
        String[] result = str.split(",");

        // then
        assertAll(
                () -> assertThat(result.length).isEqualTo(2),
                () -> assertThat(result).contains("1"),
                () -> assertThat(result).contains("2")
        );
    }

    @DisplayName("1, 문자열을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지 확인")
    @Test
    public void splitSingleArrayTest() {
        // given
        String str = "1,";

        // when
        String[] result = str.split(",");

        // then
        assertAll(
                () -> assertThat(result.length).isEqualTo(1),
                () -> assertThat(result).containsExactly("1")
        );
    }
}
