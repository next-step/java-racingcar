package step4;

import step4.car.CarStrategy;
import step4.car.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.message.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setCar() {
        car = new RacingCar("test1");
    }

    @DisplayName("입력값이 4이상이면 차가 전진, 4미만이면 정지한다.")
    @Test
    void forwardTest() {
        car.forward();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("RacingCar를 주소가 다른 같은 객체로 복사한다.")
    @Test
    void copyTest() {
        CarStrategy copyCar = car.copy();

        assertThat(copyCar.hashCode() == car.hashCode()).isFalse();
        assertThat(copyCar.getCarName().equals(car.getCarName())).isTrue();
        assertThat(copyCar.getDistance() == (car.getDistance())).isTrue();
    }

    @DisplayName("자동차들의 이름과 시도 횟수를 입력받아 자동차를 생성 할 시 자동차이름이 5를 초과하면 예외를 발생시킨다.")
    @Test
    void readyCarNameOverFiveThrowException() {
        assertThatThrownBy(() -> new RacingCar("testtest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUN_CAR_NAME_EXCEPTION.message());
    }

}
