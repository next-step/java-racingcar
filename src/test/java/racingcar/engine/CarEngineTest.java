package racingcar.engine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("[Step3] 엔진")
class CarEngineTest {

    private Engine engine = new CarEngine();
    ;

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

        // when
        int distance = engine.operate(input);

        // then
        assertThat(distance).isEqualTo(expected);
    }

    @DisplayName("[실패] 작동 - 입력 범위를 벗어남")
    @ParameterizedTest
    @CsvSource(value = {
        "-1",
        "10"}
    )
    public void operate_outOfRange(int input) {
        // given

        // when
        assertThrows(IllegalArgumentException.class, () -> engine.operate(input));

        // then
    }
}
