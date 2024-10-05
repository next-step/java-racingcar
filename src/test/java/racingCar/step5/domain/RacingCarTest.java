package racingCar.step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("자동차 이름은 5자 이하만 입력 가능하다")
    @Test
    void limitCarName(){
        assertThatThrownBy(() -> RacingCar.ofName("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 5자 이하로 입력해주세요.");
    }


    @DisplayName("전진 조건이 4이상인 경우만 이동한다")
    @Test
    void carMove(){
        RacingCar car = RacingCar.ofName("sklee");

        car.move(4);
        car.move(4);

        assertThat(car.isSamePosition(2)).isTrue();
    }

    @DisplayName("전진 조건이 4미안인 경우 이동하지 못한다")
    @Test
    void canNotMove(){
        RacingCar car = RacingCar.ofName("sklee");

        car.move(3);
        car.move(3);

        assertThat(car.isSamePosition(0)).isTrue();
    }

}
