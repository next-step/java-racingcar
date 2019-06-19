package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car = Car.of("henrry");

    @DisplayName("자동차 움직임 테스트")
    @Test
    public void move() {
        car.move();
        assertThat(this.car.getPosition()).isEqualTo(1);
    }

    @DisplayName("위치 잘 가져오는 지 테스트")
    @Test
    public void getPosition() {
        assertThat(this.car.getPosition()).isEqualTo(0);
    }

    @DisplayName("랜덤 값으로 잘 가져오는 지 테스트")
    @Test
    @RepeatedTest(10)
    void getCondition() {
        assertThat(this.car.getCondition()).isBetween(0,9);
    }
}
