package racingcar.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameAttributeTest {

    @DisplayName("0이하의 수로 생성할 경우 예외 발생")
    @ParameterizedTest
    @CsvSource(value = {"-1,1", "1,-1", "0,1", "1,0"}, delimiter = ',')
    void createByNegativeValueTest(int carCount, int tryCount) {
        assertThatThrownBy(() -> new GameAttribute(carCount, tryCount)).isExactlyInstanceOf(NumberFormatException.class);
    }
}
