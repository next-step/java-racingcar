package racing.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CustomRandomImplTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    void testRandomRange(int bound) {
        assertThat(new CustomRandomImpl().getRandomRange(bound)).isBetween(1, bound);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 1})
    void testRandomRangeThrowException(int bound) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CustomRandomImpl().getRandomRange(bound));
    }
}