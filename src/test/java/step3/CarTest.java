package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final Car car = new Car();

    @Test
    public void 자동차를_처음_생성하면_현재_위치는_0이다() {
        assertThat(car.location()).isEqualTo(0);
    }
}
