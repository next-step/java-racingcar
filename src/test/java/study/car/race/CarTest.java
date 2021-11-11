package study.car.race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("자동차가 전진했을 때 거리가 1이 증가하는지 검증")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void move(int moveCount) {
        Car car = new Car();
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
        assertThat(car.getDistance()).isEqualTo(moveCount);
    }
}
