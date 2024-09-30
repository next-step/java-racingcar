package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    @DisplayName("자동차는 이동한 만큼 값의 위치가 변한다")
    @Test
    void cannotMoveIfUnderFour() {
        //given
        Car car = new Car(1);

        //when
        car.move();
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차의 상태 값은 0-9사의의 숫자를 가지고 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void checkStateBetween0And9(int state){
        //given
        Car car = new Car(state);
        //when, then
        assertThat(car.getMoveCondition()).isBetween(0, 9);
    }
}