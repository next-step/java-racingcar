package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author han
 */
class NumberHelperTest {

    @ParameterizedTest
    @MethodSource("randomIntegerListProvider")
    void getRandomValue(int random) {
        assertThat(random).isLessThan(10);
    }

    @Test
    @DisplayName("Null or Negative value will return true")
    void nullOrNegative() {
        assertThat(NumberHelper.nullOrNegative(null)).isTrue();
        assertThat(NumberHelper.nullOrNegative(0)).isTrue();
    }

    static Stream<Integer> randomIntegerListProvider() {
        return IntStream.range(0, 100).mapToObj(j -> NumberHelper.getRandomValue(10));
    }
}