package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource({
            "'1,2', 3",
            "'4:13', 17",
            "'1,2:3', 6"
    })
    @DisplayName("기본 구분자 테스트")
    public void inputDefaultDelimiter(String input, int expected) {
        assertThat(StringAdder.sum(input))
                .as("%s 입력 시 %d가 계산 결과로 나와야 함", input, expected)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "'//k\n4k13', 17",
            "'//,\n1,2', 3",
            "'//a\n1,2:3a4', 10",
            "'//a\n3', 3",
            "'//?\n1?2', 3",
    })
    @DisplayName("커스텀 구분자 테스트")
    public void inputCustomDelimiter(String input, int expected) {
        assertThat(StringAdder.sum(input))
                .as("%s 입력 시 %d가 계산 결과로 나와야 함", input, expected)
                .isEqualTo(expected);
    }
}