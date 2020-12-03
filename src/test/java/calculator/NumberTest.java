package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("숫자(Number) 테스트")
public class NumberTest {

    @DisplayName("문자열을 통해 만들 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "0", "10"})
    void create(String value) {
        // when
        Number number = Number.valueOf(value);

        // then
        assertThat(number).isNotNull();
    }

    @DisplayName("숫자가 같으면 같은 객체로 판별한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "0", "10"})
    void equalsAndHashcode(String value) {
        // when
        Number number = Number.valueOf(value);
        Number other = Number.valueOf(value);

        // then
        assertThat(number).isEqualTo(other);
        assertThat(number.hashCode()).isEqualTo(other.hashCode());
    }

    @DisplayName("숫자가 아닌 문자열 일 경우 예외처리 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", ".", "-"})
    void createNumberFormat(String value) {
        // when / then
        assertThrows(NumberFormatException.class, () -> {
            Number.valueOf(value);
        });
    }

    @DisplayName("캐싱을 통해 같은 객체를 보장한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "0", "10"})
    void cache(String value) {
        // when
        Number number = Number.valueOf(value);
        Number other = Number.valueOf(value);

        // then
        assertThat(number).isSameAs(other);
    }
}
