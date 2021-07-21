package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @DisplayName("이동 조건을 만족하면 position 값을 증가 시킨다.")
    @Test
    void moveCar() {
        //given
        Car car = new Car();
        MovingStrategy movingStrategy = () -> true;

        //when
        car.race(movingStrategy);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 조건을 만족하지 않으면 position 값을 증가 시키지 않는다.")
    @Test
    void stopCar() {
        //given
        Car car = new Car();
        MovingStrategy movingStrategy = () -> false;

        //when
        car.race(movingStrategy);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("두번 움직이고 한번 움직이지 못하는 조건일경우 자동차의 포지션은 2이다")
    @Test
    void carPositionTest() {
        //given
        Car car = new Car();
        MovingStrategy moveStrategy = () -> true;
        MovingStrategy stopStrategy = () -> false;

        //when
        car.race(moveStrategy);
        car.race(moveStrategy);
        car.race(stopStrategy);

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }
    
}
