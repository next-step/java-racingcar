package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("name 확인")
    void constructorTest() {
        // given
        int number = 1;

        // when
        Car car = new Car(number);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("자동차1");
    }

    @Test
    @DisplayName("position 확인")
    void setPositionTest() {
        // given
        int number = 1;
        Car car = new Car(number);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
