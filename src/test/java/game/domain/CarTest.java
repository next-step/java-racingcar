package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    private void setCar() {
        car = new Car();
    }

    @ParameterizedTest(name = "자동차의 위치를 숫자만큼 증가시킨다")
    @ValueSource(ints = {1, 33, 999})
    void forward(int number) {
        int expected = car.location() + number;

        car.forward(number);

        assertThat(car.location()).isEqualTo(expected);
    }

}
