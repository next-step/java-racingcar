package racingcar.car;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    Car car=null;

    @Before
    public void setUp() throws Exception {
        this.car = new Car(4);
    }

    @Test
    public void car객체_생성() {
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @Test
    public void 파워를_얻어보자() {
        car.move();
        assertThat(car.getPosition()).isBetween(4,5);
    }
}