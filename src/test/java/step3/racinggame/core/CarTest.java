package step3.racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("전진하기 충분한 연료를 주입할 경우 전진 성공하는 테스트")
    void move_car_success() {
        Car car = new Car();
        int beforePosition = car.getDistance();
        final int possibleMoveFuel = 8;

        car.move(possibleMoveFuel);

        assertThat(car.getDistance()).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("전진하기 부족한 연료를 주입할 경우 전진 실패하는 테스트")
    void move_car_fail() {
        Car car = new Car();
        int beforePosition = car.getDistance();
        final int impossibleMoveFuel = 3;

        car.move(impossibleMoveFuel);

        assertThat(car.getDistance()).isEqualTo(beforePosition);
    }

}
