package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차가 전진한만큼 차 위치 이동")
    void moveTest(int moveCount) {
        Car car = new Car(new FixedGenerator(MovingCondtion.MOVABLE_MIN_VALUE), "test");
        for (int i = 0; i < moveCount; i++) {
            car.tryMove();
        }

        assertThat(car.getPosition()).isEqualTo(moveCount);
    }

    @Test
    void carName_다섯글자이하() {
        String carName = "test";
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    void carName_다섯글자초과() {
        String carName = "다섯글자초과";
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(RuntimeException.class);
    }
}
