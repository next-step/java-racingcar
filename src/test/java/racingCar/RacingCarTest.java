package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @DisplayName("자동차의 상태 값이 4미만이면 전진이 불가능하다")
    @Test
    void cannotMoveIfUnderFour() {
        //given
        Car car = new Car(1);

        //when, then
        assertThat(car.isMoveable()).isFalse();
    }

    @DisplayName("자동차의 상태 값이 4이상이면 전진이 가능하다")
    @Test
    void canMoveIfAtLeastFour(){
        //given
        Car car = new Car(4);

        //when, then
        assertThat(car.isMoveable()).isTrue();
    }

    @DisplayName("자동차의 상태 값은 0-9사의의 숫자를 가지고 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void checkStateBetween0And9(int state){
        //given
        Car car = new Car(state);
        //when, then
        assertThat(car.getState()).isBetween(0, 9);
    }

}