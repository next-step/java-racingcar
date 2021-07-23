package racing.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FuelTest {
    @Test
    public void emptyTest() {
        assertThat(Fuel.EMPTY.isMovable(Car.REQUIRED_FUEL_VALUE))
                .isEqualTo(false);
    }

    @Test
    public void fullTest() {
        assertThat(Fuel.FULL.isMovable(Car.REQUIRED_FUEL_VALUE))
                .isEqualTo(true);
    }

    @Test
    public void randomTest() {
        boolean movable = false;
        for (int i = 0; i < Integer.MAX_VALUE && !movable; i++) {
            movable = Fuel.randomInstance().isMovable(
                    Car.REQUIRED_FUEL_VALUE
            );
        }
        assertThat(movable)
                .isEqualTo(true);
    }
}