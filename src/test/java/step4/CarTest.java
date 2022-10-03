package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void inputCarExceptionTest() {
        assertThatThrownBy(() -> {
            new Car("123456", new Position());
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void inputCarTest() {
        Car car = new Car("1234", new Position());

        assertThat(car.getName()).isEqualTo("1234");
        assertThat(car.getPosition()).isEqualTo(new Position());
    }
}
