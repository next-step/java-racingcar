package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("전략에 따라 자동차 전진 또는 멈춤")
    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"}, delimiter = ',')
    void carMoveForward(Boolean isMovable, int expected) {
        CarMoveStrategy moveStrategy = () -> isMovable;
        assertThat(new Car().run(moveStrategy)).isEqualTo(expected);
    }
}