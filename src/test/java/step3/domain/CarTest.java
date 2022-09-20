package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {

    NumberGenerator advance = () -> 4;
    NumberGenerator notAdvance = () -> 3;


    @Test
    @DisplayName("Car 객체 생성 테스트")
    void constructorCarTest() {
        assertDoesNotThrow(Car::new);
    }

    @Test
    @DisplayName("Car 전진 테스트")
    void moveCarTest() {
        //given
        Car car = new Car();

        //when
        car.move(advance);

        //then
        assertThat(car.state()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car Not 전진 테스트")
    void notMoveCarTest() {
        //given
        Car car = new Car();

        //when
        car.move(notAdvance);

        //then
        assertThat(car.state()).isEqualTo(0);
    }
}
