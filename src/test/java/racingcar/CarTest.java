package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차를 생성한다.")
    void createCar() {
        //given
        Vehicle car = new Car();

        //when & then
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차를 한칸 움직인다.")
    void moveCar() {
        //given
        Car car = new Car();

        //when
        car.move();

        //then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}
