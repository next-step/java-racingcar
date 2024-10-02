package racingCar.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @DisplayName("자동차의 상태 값이 4미만이면 전진할 수 없으므로 위치가 변하지 않는다")
    @Test
    void cannotMoveIfUnderFour() {
        //given
        Car car = new Car();

        //when
        int currentPosition = car.getPosition();
        car.move(1);
        car.move(3);

        //then
        assertThat(car.getPosition()).isEqualTo(currentPosition);
    }

    @DisplayName("자동차의 상태 값이 4이상이면 이동한 수만큼 위치가 증가한다")
    @Test
    void canMoveIfAtLeastFour(){
        //given
        Car car = new Car();
        int currentPosition = car.getPosition();

        //when
        car.move(4);
        car.move(9);

        //then
        assertThat(car.getPosition()).isEqualTo(currentPosition + 2);
    }

    @DisplayName("자동차는 멈추거나, 앞으로만 간다")
    @Test
    void moveForward(){
        //given
        Car car = new Car();

        //when, then
        int startPosition = car.getPosition();
        car.move(1);
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(startPosition);

        car.move(9);
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(startPosition);
    }

}