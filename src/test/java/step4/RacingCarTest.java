package step4;

import step4.car.CarStrategy;
import step4.car.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setCar() {
        car = new RacingCar("test1, test2, test3");
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

}
