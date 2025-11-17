package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void 자동차를_생성하면_첫_위치가_0이_된다() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 랜덤_값이_0과3_사이의_값일_때는_전진하지_않는다(int randomNumber) {
        Car car = new Car();
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 랜덤_값이_4와9_사이의_값일_때는_전진한다(int randomNumber) {
        Car car = new Car();
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}
