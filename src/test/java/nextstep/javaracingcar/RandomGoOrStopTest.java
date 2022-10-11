package nextstep.javaracingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGoOrStopTest {

    @DisplayName("랜덤에서 기준값 보다 크거나 같으면 1을 이동한다.")
    @ParameterizedTest
    @CsvSource({"5,4", "2,2", "9,4", "3,3"})
    public void spec01(final int randomValue, final int base) {
        final RandomGoOrStop randomGoOrStop = new RandomGoOrStop(() -> randomValue, base);
        assertThat(randomGoOrStop.move()).isEqualTo(Distance.ONE);
    }

    @DisplayName("랜덤에서 기준값 보다 작으면 0을 이동한다.")
    @ParameterizedTest
    @CsvSource({"1,4", "2,3", "4,8"})
    public void spec02(final int randomValue, final int base) {
        final RandomGoOrStop randomGoOrStop = new RandomGoOrStop(() -> randomValue, base);
        assertThat(randomGoOrStop.move()).isEqualTo(Distance.ZERO);
    }
}
