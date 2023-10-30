package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StringTest {

    @Test
    @DisplayName("split() 메소드를 테스트한다.")
    void split() {
        // given
        String data = "1,2";

        // when
        String[] split = data.split(",");

        // then
        assertAll(
                () -> assertThat(split).contains("1"),
                () -> assertThat(split).contains("2"),
                () -> assertThat(split).containsExactly("1", "2")
        );
    }
}
