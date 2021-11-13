package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("전진")
    void forward(int condition) {
        Car car = new Car("pobi");
        car.moveOnSatisfiedCondition(condition);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("움직이지 않음")
    void hold(int condition) {
        Car car = new Car("pobi");
        car.moveOnSatisfiedCondition(condition);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}