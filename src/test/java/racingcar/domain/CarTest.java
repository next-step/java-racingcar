package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static final Car MOVING_CAR = new Car(1);

    @Test
    @DisplayName("자동차가 움직이는 기능 구현 : 랜덤값에 의해 자동차의 위치가 1 증가하였음을 생성자로 비교 확인")
    void movingCarTest_positionOneIncrease() {
        Car car = new Car();
        car.move(() -> true);
        assertThat(car).isEqualTo(MOVING_CAR);
    }
}
