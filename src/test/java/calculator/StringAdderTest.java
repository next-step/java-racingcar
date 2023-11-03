package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAdderTest {
    @Test
    @DisplayName("빈 문자열 입력 테스트")
    public void inputEmptyString() {
        assertThat(StringAdder.sum(""))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("null 처리 테스트")
    public void inputNull() {
        assertThat(StringAdder.sum(null))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("구분자 없는 입력 테스트")
    public void inputNoDelimiter() {
        assertThat(StringAdder.sum("13"))
                .isEqualTo(13);
    }
}