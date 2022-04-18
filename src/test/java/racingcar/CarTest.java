package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {
    private static final int MOVABLE_NUMBER = 5;
    @Test
    @DisplayName("5번 움직인 자동차와 Position이 5인 자동차는 같다")
    void 다섯번_움직인_자동차와_Position이_5인_자동차는_같다 () {
        Car car = new Car(new Position());
        int moveCount = 5;
        for (int count = 0; count < moveCount; count++) {
            car.play(MOVABLE_NUMBER);
        }
        car.getDistance();
        assertThat(car).isEqualTo(new Car(new Position(moveCount)));
    }

    @Test
    @DisplayName("자동차가 4 이상의 숫자를 받으면 움직인다.")
    void move_test() {
        Car car = new Car();
        car.play(4);
        car.play(3);
        car.play(3);

        assertThat(car).isEqualTo(new Car(new Position(1)));
    }
}
