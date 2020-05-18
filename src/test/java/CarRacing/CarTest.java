package CarRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("Car Init")
    public void carInitTest() {
        Car car = new Car("1", new Position());
        assertThat(car.isLocationAt(0)).isTrue();
    }

    @Test
    @DisplayName("Car Forward Move")
    public void carForwardMoveTest() {
        Car car = new Car("1", new Position());
        car.move(Direction.FORWARD);
        assertThat(car.isLocationAt(1)).isTrue();
    }

    @Test
    @DisplayName("Car Back Move")
    public void carBackMoveTest() {
        Position position = new Position();
        position.setLocation(1);
        Car car = new Car("1", position);
        car.move(Direction.BACK);
        assertThat(car.isLocationAt(0)).isTrue();
    }

    @Test
    @DisplayName("Car Zero Back Move")
    public void carZeroBackMoveTest() {
        assertThatThrownBy(() -> {
            Car car = new Car("1", new Position());
            car.move(Direction.BACK);
        }).isInstanceOf(IllegalStateException.class);
    }
}
