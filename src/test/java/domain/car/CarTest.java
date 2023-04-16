package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static domain.car.Car.MAX_LENGTH_OF_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest(name = "전진 전략이 {0}이면 차의 주행거리가 {1} 증가한다.")
    @CsvSource(value = {"true,1", "false,0"})
    void 전진조건이_참이면_차가_전진한다(boolean condition, int result) {

        // given
        Car car = new Car("car");

        // when
        car.go(() -> condition);

        // then
        assertThat(car.distance()).isEqualTo(result);
    }

    @Test
    @DisplayName("차의 이름은 5자 초과가 될 수 없다.")
    void 차의_이름이_5자_초과이면_예외가_발생한다() {

        // given
        String testName = "abcdef";

        // then
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 " +  MAX_LENGTH_OF_NAME + " 자 이하로 입력해주세요. : " + testName);
    }
}
