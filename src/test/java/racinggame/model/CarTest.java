package racinggame.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * **************************************
 * racinggame.model
 * **************************************
 * Created by on [05/11/2018 | Chris]
 * Task ::
 */

public class CarTest {
    private static Car car;

    private static final String TEST_CAR_NAME = "TEST_CAR_NAME";

    @Before
    public void setUp() {
        car = new Car(TEST_CAR_NAME);
    }

    @Test
    public void 자동차_움직이기_시도() throws Exception {
        car.moveCar();

        assertThat(car.getPosition()).isLessThanOrEqualTo(1);
    }

    @Test
    public void 자동차_움직임_가능여부_테스트() {

        boolean canMove = car.isCarMove(5);
        boolean canNotMove = car.isCarMove(1);

        assertThat(canMove).isTrue();
        assertThat(canNotMove).isFalse();

    }
}