package racingcar.engine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("[Step3] 엔진")
class CarEngineTest {

    private Engine engine;

    @DisplayName("[성공] 작동 - 자동차 엔진")
    @ParameterizedTest
    @CsvSource(value = {
        "0,0",
        "1,0",
        "3,0",
        "4,1",
        "9,1"}
    )
    public void operate_carEngine(int input, int expected) {
        // given
        engine = new CarEngine();

        // when
        int distance = engine.operate(input);

        // then
        assertThat(distance).isEqualTo(expected);
    }
}
