package step3.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Disabled
    @Test
    void move_moveCarIfRandomNumberIsValid_void() {

        // TODO : Random 테스트
        // Given
        Car car = new Car();
        Fuel fuel = new Fuel();
        int result = 1;

        // When
        car.move(fuel);

        // Then
        assertThat(car.getDistance()).isEqualTo(result);
    }
}