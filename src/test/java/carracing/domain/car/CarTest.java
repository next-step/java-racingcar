package carracing.domain.car;

import carracing.domain.game.RandomRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final int ZERO = 0;
    private static final int MOVING = 1;
    private CarName carName;
    private Car car;

    @BeforeEach
    void setUp() {
        carName = new CarName("abc");
        car = new Car(carName);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void moveCarSuccessBoundary(int number) {
        car.move(new RandomRange(number, number));

        assertThat(car.movingDistance()).isEqualTo(MOVING);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void moveCarFalseBoundary(int number) {
        car.move(new RandomRange(number, number));

        assertThat(car.movingDistance()).isEqualTo(ZERO);
    }

    @Test
    void carTryMovingOutOfRandomRange() {
        assertThatThrownBy(
            () -> car.move(new RandomRange(11, 20))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sameDistance_sameMovingDistance_true() {
        Car car = new Car(10, carName);

        boolean sameDistance = car.sameDistance(10);

        assertThat(sameDistance).isTrue();
    }

    @Test
    void sameDistance_differentMovingDistance_false() {
        Car car = new Car(10, carName);

        boolean sameDistance = car.sameDistance(5);

        assertThat(sameDistance).isFalse();
    }
}

