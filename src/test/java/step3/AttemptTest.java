package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100000000})
    void illegalAttempt(int number) {
        assertThatThrownBy(() -> { new Attempt(number); })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, true", "4, false"})
    void testIsEnd(int number, boolean expect) {
        Attempt attempt = new Attempt(number);
        attempt.make();
        boolean isEnd = attempt.isEnd();
        assertThat(isEnd).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isEqualNumber(int number) {
        Attempt attempt = new Attempt(number);
        boolean result = attempt.isEqualNumber(number);
        assertThat(result).isTrue();
    }


}