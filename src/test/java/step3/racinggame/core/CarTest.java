package step3.racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("연료주입량에 따른 자동차의 전진 테스트 - 전진 성공")
    void move_car_success() {
        Car car = new Car();
        int beforePosition = car.whereAmI();
        final int possibleMoveFuel = 8;

        car.move(possibleMoveFuel);

        assertThat(car.whereAmI()).isEqualTo(beforePosition + 1);
    }

    @Test
    @DisplayName("연료주입량에 따른 자동차의 전진 테스트 - 전진 실패")
    void move_car_fail() {
        Car car = new Car();
        int beforePosition = car.whereAmI();
        final int impossibleMoveFuel = 3;

        car.move(impossibleMoveFuel);

        assertThat(car.whereAmI()).isEqualTo(beforePosition);
    }

}