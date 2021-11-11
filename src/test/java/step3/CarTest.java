package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차_4이상_앞으로_이동() {
        assertThat(new Car().move(5)).isEqualTo(new Car(1));
        assertThat(new Car().move(4)).isEqualTo(new Car(1));
        assertThat(new Car(6).move(4)).isEqualTo(new Car(7));
    }
    @Test
    void 자동차_4미만_제자리() {
        assertThat(new Car(3).move(3)).isEqualTo(new Car(3));
        assertThat(new Car().move(2)).isEqualTo(new Car());
        assertThat(new Car(5).move(1)).isEqualTo(new Car(5));
    }
}
