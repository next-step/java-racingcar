import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    @DisplayName("입력값이 4 이상이면 전진한다")
    void carMoveForward() {

        Car car = new Car();
        car.moveForward(5);

        assertThat(car.getPosition()).isEqualTo(1);
    }



    @Test
    @DisplayName("입력값이 4 미만이면 전진 불가능하다")
    void cannotMoveInputLessThan_4() {

        Car car = new Car();
        car.moveForward(3);

        assertThat(car.getPosition()).isZero();
    }


    @DisplayName("자동차 이름을 부여한다")
    @Test
    void carNameTest() {
        // given
        Car porsche = new Car("포르쉐");

        // when
        // then
        assertThat(porsche.getName()).isEqualTo("포르쉐");
    }


    @DisplayName("자동차 이름을 5글자를 초과할 수 없다")
    @Test
    void carNameLengthShouldUnder5() {

        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new Car("포르쉐쉐쉐쉐"));
    }

}
