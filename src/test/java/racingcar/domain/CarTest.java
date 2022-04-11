package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("move 호출 횟수로 동등성 비교")
    @Test
    void move() {
        Car car1 = new Car(new Position());
        Car car2 = new Car(new Position());

        int moveCount = 3;
        for (int i = 0; i < moveCount; i++) {
            car1.move();
            car2.move();
        }

        assertThat(car1).isEqualTo(car2);
    }
}
