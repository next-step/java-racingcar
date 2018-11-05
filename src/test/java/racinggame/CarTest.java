package racinggame;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @Before
    public void 자동차_셋팅(){
        car = new Car("pobi");
    }

    @Test
    public void 자동차_이동() {
        car = new Car("pobi");
        car.move(() -> true);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @Test
    public void 자동차_정지() {
        car = new Car("pobi");
        car.move(() -> false);
        assertThat(car.getLocation()).isEqualTo(0);

    }

    @Test
    public void 자동차_생성여부() {
        car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");

    }
}