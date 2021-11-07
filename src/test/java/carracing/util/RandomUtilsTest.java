package carracing.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomUtilsTest {

    @ParameterizedTest
    @DisplayName("랜덤 값이 0 - 9 사이인지 확인")
    @CsvSource(value = {"0:9"}, delimiter = ':')
    void randomValueByZeroToNineBetween(Integer min, Integer max) {
        assertThat(RandomUtils.nextInt()).isBetween(min, max);
    }

    @ParameterizedTest
    @DisplayName("랜덤 값이 파라미터보다 작은지 확인")
    @ValueSource(ints = 20)
    void randomValueLessThanByParameter(Integer max) {
        assertThat(RandomUtils.nextInt(max)).isLessThan(max);
    }

}
