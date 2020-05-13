package CarRacing;

import StringCalculator.ArithmeticExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @Test
    @DisplayName("Car Init")
    public void carInitTest() {
        Car car = new Car("1", new Position());
        assertThat(car.getPosition().location).isEqualTo(0);
    }

    @Test
    @DisplayName("Car Forward Move")
    public void carForwardMoveTest() {
        Car car = new Car("1", new Position());
        car.move(Direction.FORWARD);
        assertThat(car.getPosition().location).isEqualTo(1);
    }

    @Test
    @DisplayName("Car Back Move")
    public void carBackMoveTest() {
        Position position = new Position();
        position.location = 1;
        Car car = new Car("1", position);
        car.move(Direction.BACK);
        assertThat(car.getPosition().location).isEqualTo(0);
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
