package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_앞으로_이동() {
        assertThat(new Car().move(5)).isEqualTo(new Car(1));
        assertThat(new Car().move(3)).isEqualTo(new Car());
    }
}
