
package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    //given
    Car car = new Car("poby");

    @Test
    @DisplayName("(1)위치를 비교하고 큰 값을 전달")
    public void max() {
        //given
        Car car = new Car("poby", 3);
        Assertions.assertThat(car.max(2)).isEqualTo(3);
        Assertions.assertThat(car.max(4)).isEqualTo(4);
    }

    @Test
    @DisplayName("(2)입력한 숫자와 해당 자동차의 위치가 동일한지 체크")
    public void isMatchTest() {
        //given
        Car car = new Car("poby", 3);

        //when, then
        Assertions.assertThat(car.isMatch(3)).isEqualTo(true);
    }

    @Test
    @DisplayName("(3)자동차의 위치를 전달")
    public void carName() {
        //when, then
        Assertions.assertThat(car.name()).isEqualTo("poby");
    }

    @Test
    @DisplayName("(4)자동차의 위치를 전달")
    public void position() {
        //when, then
        Assertions.assertThat(car.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("(5)자동차의 위치를 업데이트")
    public void updatePosition() {
        //when
        car.updatePosition(5);

        //then
        Assertions.assertThat(car.position()).isEqualTo(1);
    }
}
