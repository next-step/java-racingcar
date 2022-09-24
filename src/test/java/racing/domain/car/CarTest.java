package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성 테스트")
    void constructorCarTest() {
        assertDoesNotThrow(() -> new Car("name"));
    }

    @Test
    @DisplayName("Car 전진 테스트")
    void moveCarTest() {
        //given
        Car car = new Car("joo");

        //when
        Car moveCar = car.move();

        //then
        assertThat(moveCar).isEqualTo(new Car(1, "joo"));
    }
}
