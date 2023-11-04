package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차를 생성할 때 이동 위치의 기본 값을 1로 설정한다.")
    @Test
    void createCar() {
        // given
        Car car = new Car();

        // when
        int currentPosition = car.getCurrentPosition();

        // then
        assertThat(currentPosition).isEqualTo(1);
    }

    @DisplayName("자동차의 엑셀을 밟는 힘이 4이상이면 앞으로 이동한다.")
    @ParameterizedTest
    @CsvSource({"1,1", "3,1", "4,2", "9,2"})
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
    @Test
    void moveForwardWhenOverAndUnderPower() {
        // given
        Car car = new Car();
        int power = 10;

        // when & then
        assertThatThrownBy(() -> car.moveForward(power))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("엑셀의 작동 범위를 벗어납니다.");
    }
}