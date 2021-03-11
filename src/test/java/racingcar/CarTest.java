package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource({"3, 0", "4, 1"})
    @DisplayName("경계값 분석을 통해 4이상인 경우 전진하고, 미만인 경우 멈추는지 확인한다.")
    void updateByOver4(int number, int position) {
        Car car = new Car("jhLim");

        car.updatePositionByCondition(number);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    @DisplayName("자동차의 출력 될 상태를 확인한다.")
    void checkPosition(int position) {
        Car car = new Car("jhLim",position);

        assertThat(car.getPosition()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    @DisplayName("0에서 9사이의 숫자 이외에는 자동차가 판단할 수 없다.")
    void checkRange(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("jhLim97").positionValueValidation(number);
        });
    }

    @ParameterizedTest
    @CsvSource({"3, ---"})
    @DisplayName("자동차의 위치를 표시할 수 있다.")
    void canDisplayCarPosition(int position, String displayPosition) {
        Assertions.assertThat(new Car("jhLim", position).toString()).isEqualTo(displayPosition);
    }
}