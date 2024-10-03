package racingCar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @DisplayName("자동차의 이름은 5자 초과하여 입력할 수 없다")
    @Test
    void validateCarNameSize(){
        assertThatThrownBy(() -> RacingCar.createCarWithName("자동차이름5자초과"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하만 입력 가능합니다");
    }

    @DisplayName("자동차의 상태 값이 4미만이면 전진할 수 없으므로 위치가 변하지 않는다")
    @Test
    void cannotMoveIfUnderFour() {
        //given
        RacingCar car = RacingCar.createCarWithName("sklee");

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
        RacingCar car = RacingCar.createCarWithName("sklee");
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
        RacingCar car = RacingCar.createCarWithName("sklee");

        //when, then
        int startPosition = car.getPosition();
        car.move(1);
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(startPosition);

        car.move(9);
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(startPosition);
    }
}