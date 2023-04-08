package racingcar.control;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 컨트롤러 테스트")
class RaceControlTest {

    @ParameterizedTest
    @DisplayName("입력이 음수라면 예외가 나야 한다")
    @CsvSource(value = {"-1,-1", "-1,0", "0,-1"})
    public void bePositive(int cars, int trials) {
        assertThatThrownBy(() -> new RaceControl(cars, trials))
                .isInstanceOf(IllegalArgumentException.class);
    }
}