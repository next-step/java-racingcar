package step03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateUtilsTest {

    @ParameterizedTest
    @CsvSource({"0,0", "0,1", "1,0"})
    void inputIsZero(int carCount, int tryCount) {
        assertThatThrownBy(() ->
                new RacingEventManager(carCount, tryCount)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 0 이상이어야 합니다.");
    }
}
