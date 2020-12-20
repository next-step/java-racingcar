package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 전진 유무 체크")
    void carMove() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);

        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
