package racing;

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

    static Stream<Integer> randomIntegerListProvider() {
        return IntStream.range(0, 100).mapToObj(j -> NumberHelper.getRandomValue(10));
    }
}