package calculator.separator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SimpleSeparatorTest {

    private Separator separator;

    @BeforeEach
    void setUp() {
        separator = new SimpleSeparator();
    }

    @ParameterizedTest
    @DisplayName("숫자 1개로 이루어진 문자열인지 확인한다.")
    @CsvSource(value = {"4, true", "4:3, false", "&*, false"})
    void matchable(String given, boolean expected) {
        // when
        boolean result = separator.matchable(given);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 하나를 분리한다.")
    @CsvSource(value = {"4, 4", "3412, 3412"})
    void separate(String given, String expected) {
        // when
        List<String> result = separator.separate(given);

        // then
        assertThat(result).isEqualTo(List.of(expected));
    }
}