package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegerRandomListGeneratorTest {
    private RandomListGenerator<Integer> sut = IntegerRandomListGenerator.getInstance();

    @ParameterizedTest
    @MethodSource("provideTestArgs")
    void check_random_list_size_and_volume(int size, int bound) {
        assertThat(sut.gacha(size, bound).size()).isEqualTo(size);
        assertTrue(sut.gacha(size, bound)
                      .stream()
                      .max(Integer::compareTo).get() <= bound);
    }

    private static Stream<Arguments> provideTestArgs() {
        return Stream.of(
                Arguments.of(3, 5),
                Arguments.of(10, 10)
        );
    }
}
