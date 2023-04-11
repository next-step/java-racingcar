package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomNumberGeneratorTest {

    @DisplayName("범위가 설정되지 않은 제너레이터의 최소값은 0이상이다.")
    @Test
    public void 제너레이터_범위미설정_최소값() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThat(randomNumberGenerator.generate() >= 0).isTrue();
    }

    @DisplayName("범위가 설정되지 않은 제너레이터의 최대값은 10보다 작다.")
    @Test
    public void 제너레이터_범위미설정_최대값() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        assertThat(randomNumberGenerator.generate() < 10).isTrue();
    }

    @DisplayName("제너레이터 최대값 설정이 0보다 작을경우 에러를 던진다.")
    @Test
    void 제너레이터_최대값_음수() {
        assertThatThrownBy(() -> new RandomNumberGenerator(0, -20)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제너레이터 최대값 설정이 10보다 클경우 에러를 던진다.")
    @Test
    void 제너레이터_최대값_10초과() {
        assertThatThrownBy(() -> new RandomNumberGenerator(0, 15)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제너레이터 최소값 설정이 0보다 작을경우 에러를 던진다.")
    @Test
    void 제너레이터_최소값_0미만() {
        assertThatThrownBy(() -> new RandomNumberGenerator(-10, 5)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("제너레이터 최소값 최대값에 합이 9를 넘을경우 에러를 던진다.")
    @Test
    void 제너레이터_최소값_최대값_합이_9초과() {
        assertThatThrownBy(() -> new RandomNumberGenerator(5, 6)).isInstanceOf(IllegalArgumentException.class);
    }

}
