package study.racing.utils;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ScannerUtilsTest {

    @DisplayName("숫자를 입력으로 받으면 정상적으로 int형으로 반환하는지 검증")
    @ParameterizedTest(name = "\"{0}\"이 {1}로 변환")
    @CsvSource("1, 1")
    void nextIntTest(String input, int expected) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        int result = ScannerUtils.nextInt();

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자를 입력으로 받으면 정상적으로 int형으로 반환하는지 검증")
    @ParameterizedTest
    @ValueSource(strings = { "a", "ab", "a-b+3" })
    void nextIntNotANumberInputTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> ScannerUtils.nextInt()).isInstanceOf(RuntimeException.class);
    }
}
