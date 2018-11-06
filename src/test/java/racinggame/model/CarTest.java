package racinggame.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    private static Car car;

    private static final String TEST_CAR_NAME = "TEST_CAR_NAME";

    @Before
    public void setUp() {
        car = new Car(TEST_CAR_NAME);
    }

    @Test
    public void 자동차_움직이기_시도() throws Exception {
        car.moveCar(0);
        assertThat(car.getPosition()).isEqualTo(0);

        car.moveCar(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_움직임_가능여부_테스트() {

        boolean canMove = car.isCarMove(5);
        boolean canNotMove = car.isCarMove(1);

        assertThat(canMove).isTrue();
        assertThat(canNotMove).isFalse();

    }
}