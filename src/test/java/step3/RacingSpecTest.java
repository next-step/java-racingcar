package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingSpecTest {

    @DisplayName("객체 생성 테스트 - 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {
            "-1:-10",
            "-1:10",
            "1:-10"
    }, delimiter = ':')
    public void test(Integer carCount, Integer moveCount) {
        assertThatThrownBy(() -> {
            RacingSpec racingSpec = new RacingSpec(carCount, moveCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
