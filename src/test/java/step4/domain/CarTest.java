package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차를 생성할 때 이동 위치의 기본 값을 0으로 설정한다.")
    @Test
    void createCar() {
        // given
        Car car = new Car();

        // when
        int currentPosition = car.getCurrentPosition();

        // then
        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("자동차의 엑셀을 밟는 힘이 4이상이면 앞으로 이동한다.")
    @ParameterizedTest
    @CsvSource({"1,0", "3,0", "4,1", "9,1"})
    void moveForward(int power, int expectedPosition) {
        // given
        Car car = new Car();
        car.moveForward(power);

        // when
        int realPosition = car.getCurrentPosition();

        // then
        assertThat(realPosition).isEqualTo(expectedPosition);
    }

    @DisplayName("자동차의 엑셀을 밟는 힘이 0~9의 범위를 넘어서면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void moveForwardWhenOverAndUnderPower(int power) {
        // given
        Car car = new Car();

        // when & then
        assertThatThrownBy(() -> car.moveForward(power))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("엑셀의 작동 범위를 벗어납니다.");
    }
}