package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
class CarTest {
    private final int movePosition = 1;
    private final int stopPosition = 0;

    @Test
    @DisplayName("차 이동 여부에 따라 포지션(이동:1, 정지:0)을 테스트한다.")
    void moveTest() {
        Car car = new Car();
        car.move();
        assertThat(car.showMyPosition()).isBetween(stopPosition, movePosition);

    }
}