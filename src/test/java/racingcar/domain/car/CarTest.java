package racingcar.domain.car;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    Car car = null;
    public static final String NAME = "pobi";

    @Before
    public void setUp() throws Exception {
        this.car = new Car(NAME, 10);
    }

    @Test
    public void car객체_확인() {
        assertThat(car.getName()).isEqualTo(NAME);
        assertThat(car.getPosition()).isEqualTo(10);
    }

    @Test
    public void 파워를_얻어보자() {
        int position = car.move();
        assertThat(position).isBetween(10, 11);
    }
}