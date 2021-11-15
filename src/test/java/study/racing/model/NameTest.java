package study.racing.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NameTest {

    @DisplayName("인자로 받은 length 보다 긴 이름인지 검증")
    @ParameterizedTest
    @CsvSource(value = { "abc, 1", "a, 0" })
    void longerThanTest(String name, int length) {
        assertThat(new Name(name).longerThan(length)).isTrue();
    }
}
