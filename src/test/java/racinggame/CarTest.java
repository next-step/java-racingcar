package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차를_생성하면_처음_거리는_1이다() {
        Car actual = new Car();
        Car expected = new Car(1);

        assertThat(actual).isEqualTo(expected);
    }

}
