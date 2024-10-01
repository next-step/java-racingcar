package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.step3.Car;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @DisplayName("자동차의 상태 값이 4미만이면 전진할 수 없으므로 위치가 변하지 않는다")
    @Test
    void cannotMoveIfUnderFour() {
        //given
        Car car = new Car();
        car.applyMoveCondition(1);

        //when
        int currentPosition = car.getPosition();
        car.move();
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(currentPosition);
    }

    @DisplayName("자동차의 상태 값이 4이상이면 이동한 수만큼 위치가 증가한다")
    @Test
    void canMoveIfAtLeastFour(){
        //given
        Car car = new Car();
        car.applyMoveCondition(4);

        //when
        int currentPosition = car.getPosition();
        car.move();
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(currentPosition + 2);
    }

    @DisplayName("자동차의 전진 조건의 값은 0-9사의의 숫자를 가지고 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void checkConditionRange(int moveCondition){
        //given
        Car car = new Car();
        car.applyMoveCondition(moveCondition);

        //when, then
        assertThat(car.getMoveCondition()).isBetween(0, 9);
    }
}