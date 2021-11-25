package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차가 전진하면 위치가 1 증가해야 한다.")
    void testWhenCarMoveThenPositionShouldIncrease() {
        // Given
        Car car = new Car();
        int startPosition = car.getPosition();

        // When
        car.run(() -> true);

        // Then
        assertThat(car.getPosition()).isEqualTo(startPosition + 1);
    }

    @Test
    @DisplayName("차가 전진하지 못하면 위치가 변하지 않아야 한다.")
    void testWhenCarCantMoveThenPositionShouldBeSame() {
        // Given
        Car car = new Car();
        int startPosition = car.getPosition();

        // When
        car.run(() -> false);

        // Then
        assertThat(car.getPosition()).isEqualTo(startPosition);
    }

    @Test
    @DisplayName("자동차는 이름을 가질 수 있다")
    void testCarCanHaveName() {
        // Given
        Car car1 = new Car("same-name");
        Car car2 = new Car("different-name");

        // When & Then
        assertThat(car1).isEqualTo(new Car("same-name"));
        assertThat(car2).isNotEqualTo(new Car("same-name"));
    }
}
