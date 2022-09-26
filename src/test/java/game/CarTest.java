package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    private void setCar() {
        car = new Car();
    }

    @DisplayName("자동차의 위치를 1 증가시킨다")
    @Test
    void forward() {
        int expected = car.location() + 1;

        car.forward();

        assertThat(car.location()).isEqualTo(expected);
    }


}
