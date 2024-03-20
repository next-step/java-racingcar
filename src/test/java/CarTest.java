import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {

    @Test
    @DisplayName("전진")
    void carMoveForward() {

        Car car = new Car();
        car.move(() -> true);

        assertThat(car.getPosition()).isEqualTo(1);
    }



    @Test
    @DisplayName("중지")
    void cannotMoveInputLessThan_4() {

        Car car = new Car();
        car.move(() -> false);

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
