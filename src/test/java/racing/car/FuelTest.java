package racing.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FuelTest {
    @Test
    public void emptyTest() {
        assertThat(Fuel.EMPTY.isMovable())
                .isEqualTo(false);
    }

    @Test
    public void minTest() {
        assertThat(Fuel.MIN.isMovable())
                .isEqualTo(true);
    }

    @Test
    public void fullTest() {
        assertThat(Fuel.FULL.isMovable())
                .isEqualTo(true);
    }

    @Test
    public void randomTest() {
        boolean movable = false;
        for (int i = 0; i < Integer.MAX_VALUE && !movable; i++) {
            movable = Fuel.RANDOM.isMovable();
        }
        assertThat(movable)
                .isEqualTo(true);
    }
}