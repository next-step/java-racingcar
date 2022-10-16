package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DistanceTest {

    @Test
    void equals_null() {
        assertThat(Distance.ZERO.equals(null))
            .isFalse();
        assertThat(Distance.ONE.equals(null))
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5 - 2, -1, 0, 1, 2, 5, 10})
    void equals_nonNull(final int value) {
        assertThat(Distance.from(value))
            .isEqualTo(Distance.from(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5 - 2, -1, 0, 1, 2, 5, 10})
    void plus_null(final int value) {
        assertThat(Distance.from(value).plus(null))
            .isEqualTo(Distance.from((value)));
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:-2:-3", "2:-2:0", "0:0:0", "1:2:3", "5:10:15",}, delimiter = ':')
    void plus(final int first, final int second, final int result) {
        assertThat(Distance.from(first).plus(Distance.from(second)))
            .isEqualTo(Distance.from(result));

        assertThat(Distance.from(second).plus(Distance.from(first)))
            .isEqualTo(Distance.from(result));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5 - 2, -1, 0, 1, 2, 5, 10})
    void isLessThan_null(final int value) {
        assertThat(Distance.from(value).isLessThan(null))
            .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"-2:-1", "-1:0", "0:1", "1:2"}, delimiter = ':')
    void isLessThan_differentValue(final int smallerValue, final int value) {
        assertThat(Distance.from(smallerValue).isLessThan(Distance.from(value)))
            .isTrue();
        assertThat(Distance.from(value).isLessThan(Distance.from(smallerValue)))
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5 - 2, -1, 0, 1, 2, 5, 10})
    void isLessThan_sameValue(final int value) {
        assertThat(Distance.from(value).isLessThan(Distance.from(value)))
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5 - 2, -1, 0, 1, 2, 5, 10})
    void isGreaterThan_null(final int value) {
        assertThat(Distance.from(value).isGreaterThan(null))
            .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"-2:-1", "-1:0", "0:1", "1:2"}, delimiter = ':')
    void isGreaterThan_differentValue(final int smallerValue, final int value) {
        assertThat(Distance.from(smallerValue).isGreaterThan(Distance.from(value)))
            .isFalse();
        assertThat(Distance.from(value).isGreaterThan(Distance.from(smallerValue)))
            .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5 - 2, -1, 0, 1, 2, 5, 10})
    void isGreaterThan_sameValue(final int value) {
        assertThat(Distance.from(value).isGreaterThan(Distance.from(value)))
            .isFalse();
    }

}
