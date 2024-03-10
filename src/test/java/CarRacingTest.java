import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarRacingTest {
    @Test
    @DisplayName("자동차 객체 생성 시 위치값은 0이다")
    void carObjectInitialValue() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상이면 전진한다")
    @ValueSource(ints = {4, 5})
    void carMoveForward(int number) {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.addPosition(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4미만이면 전진하지 않는다")
    @ValueSource(ints = {2, 3})
    void carNotMoveForward(int number) {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.addPosition(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
