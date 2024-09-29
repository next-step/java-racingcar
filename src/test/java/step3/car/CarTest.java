package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("1대의 자동차를 입력한 값만큼 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void moveCar(int position) {
        // given
        Car car = new Car();

        // when
        car.move(position);

        // then
        assertThat(car.getPosition()).isEqualTo(position);
    }

}
