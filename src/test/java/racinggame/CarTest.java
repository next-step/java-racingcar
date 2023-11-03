package racinggame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차를_생성하면_처음_거리는_1이다() {
        Car actual = new Car();
        Car expected = new Car(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차는_이동_할_수_있다() {
        Car car = new Car();

        assertAll(
            () -> {
                Car expected = new Car(2);
                car.move();

                assertThat(car).isEqualTo(expected);
            },
            () -> {
                Car expected = new Car(3);
                car.move();

                assertThat(car).isEqualTo(expected);
            }
        );
    }

}
