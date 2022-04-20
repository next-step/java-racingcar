package camp.nextstep.racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 주어진_값이_4이상일_경우만_전진() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
