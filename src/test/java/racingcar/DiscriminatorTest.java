package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DiscriminatorTest {
    @ParameterizedTest
    @DisplayName("랜덤한 0~9의 수 중 4이상일 경우 True 아니면 false")
    @MethodSource
    void discriminate(int randomToGet, boolean resultExpected) {
        Discriminator discriminator = new Discriminator(getMockRandom(randomToGet));

        boolean result = discriminator.discriminate();

        assertThat(result).isEqualTo(resultExpected);
    }

    static Stream<Arguments> discriminate() {
        Stream<Arguments> stream0To5 = IntStream.range(0, 4).mapToObj(i -> Arguments.arguments(i, false));
        Stream<Arguments> stream5To10 = IntStream.range(4, 10).mapToObj(i -> Arguments.arguments(i, true));
        return Stream.concat(stream0To5, stream5To10);
    }

    public static Random getMockRandom(int result) {
        return new Random() {
            @Override
            public int nextInt(int bound) {
                return result;
            }
        };
    }
}
