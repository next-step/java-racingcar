package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    private static final int NOT_MOVED = 0;
    private static final int MOVED = 1;

    private Car car = new Car();

    @Test
    public void 자동차_전진() {
        car.move();
        assertThat(car.position()).isIn(NOT_MOVED, MOVED);
    }

}
