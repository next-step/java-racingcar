package car.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomUtilsTest {

    private final static int BOUNDARY_VALUE = 10;

    @Test
    @DisplayName("0과 9사이의 무작위 수를 반환한다")
    void shouldBeReturnBetweenZeroAndNineByRandom() {
        // given
        int count = 100;

        //when
        IntStream.rangeClosed(0, count)
                .forEach(i -> {
                    int randomValue = RandomUtils.getRandomValueLesserThen(BOUNDARY_VALUE);
                    //then
                    assertThat(randomValue).isLessThan(10);
                });
    }
}
