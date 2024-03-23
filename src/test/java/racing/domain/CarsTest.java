package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.vo.Name;
import racing.domain.vo.Position;
import racing.util.MovableNumberGenerator;
import racing.util.NonMovableNumberGenerator;
import racing.util.NumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("숫자가 4보다 작으면 위치를 그대로 유지")
    @Test
    void stayIfNumberIstSmallerThanFour() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(1));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final NumberGenerator numberGenerator = new NonMovableNumberGenerator();
        final Cars cars = new Cars(List.of(leeCar, parkCar), numberGenerator);
        // When
        cars.move();
        // Then
        assertThat(leeCar.getPosition()).isEqualTo(1);
        assertThat(parkCar.getPosition()).isEqualTo(2);
    }

    @DisplayName("숫자가 4보다 크면 전진")
    @Test
    void moveIfNumberIstGreaterThanAndEqualToFour() {
        // Given
        final Car leeCar = new Car(new Name("lee"), new Position(1));
        final Car parkCar = new Car(new Name("park"), new Position(2));
        final NumberGenerator numberGenerator = new MovableNumberGenerator();
        final Cars cars = new Cars(List.of(leeCar, parkCar), numberGenerator);
        // When
        cars.move();
        // Then
        assertThat(leeCar.getPosition()).isEqualTo(2);
        assertThat(parkCar.getPosition()).isEqualTo(3);
    }
}
