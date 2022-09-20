package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성 테스트")
    void constructorCarTest() {
        assertDoesNotThrow(() -> new Car(0));
    }

    @Test
    @DisplayName("Car 전진 테스트")
    void moveCarTest() {
        //given
        Car car = new Car(0);

        //when
        car.move();

        //then
        assertThat(car.state()).isEqualTo(1);
    }
}
