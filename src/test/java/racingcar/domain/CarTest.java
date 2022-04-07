package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_호출마다_position_증가() {
        Car car = new Car();
        int moveCount = 3;

        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.position()).isEqualTo(moveCount);
    }
}
