package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 이름은_5자_초과_불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car("123456");
        });
    }

    @Test
    void car_입력_성공() {
        Car car = new Car("1234");

        assertThat(car.getName()).isEqualTo("1234");
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
