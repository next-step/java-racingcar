package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.Direction;
import carracing.domain.car.Position;
import carracing.domain.car.RandomValueStrategy;
import carracing.test.PositionRestrictionsStrategy;
import carracing.test.RandomMaxValue;
import carracing.test.RandomMinValue;
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
        position.move(1);
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

    @Test
    @DisplayName("Car Progress Test With True Value")
    public void carProgressTestWithTrueValue() {
        Car car = new Car("1", new Position());
        car.progress(new RandomValueStrategy(new RandomMinValue()));
        assertThat(car.isLocationAt(1)).isTrue();
    }

    @Test
    @DisplayName("Car Progress Test With False Value")
    public void carProgressTestWithFalseValue() {
        Car car = new Car("1", new Position());
        car.progress(new RandomValueStrategy(new RandomMaxValue()));
        assertThat(car.isLocationAt(0)).isTrue();
    }

    @Test
    @DisplayName("Car Progress Test With Stop Position Value")
    public void carProgressTestWithPositionValue() {
        Car car = new Car("1", new Position());
        car.move(Direction.FORWARD);
        car.move(Direction.FORWARD);
        car.move(Direction.FORWARD);
        car.progress(new PositionRestrictionsStrategy(car));
        assertThat(car.isLocationAt(3)).isTrue();
    }
}
