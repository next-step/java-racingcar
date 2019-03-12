package racingcar.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {

    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car("test");
    }

    @Test
    public void 자동차_이름_확인() {
        assertThat(car.getName()).isEqualTo("test");
    }

    @Test
    public void 최초_포지션_확인() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 앞으로_한칸_전진() {
        assertThat(car.addPosition()).isEqualTo(1);
    }

    @Test
    public void 앞으로_세칸_전진() {
        car.addPosition();
        car.addPosition();
        car.addPosition();
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
