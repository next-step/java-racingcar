package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차가 전진한만큼 차 위치 이동")
    void moveTest(int moveCount) {
        Car car = new Car(new FixedGenerator(MovingCondtion.MOVABLE_MIN_VALUE));
        for (int i = 0; i < moveCount; i++) {
            car.tryMove();
        }

        assertThat(car.getPosition()).isEqualTo(moveCount);
    }
}
