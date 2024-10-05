package race;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차를_생성하면_전진하는_방향이_하나_생성된다() {
        Car car = new Car("tCar");

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_진행조건인_4이상의_수가_주어지면_한칸_전진한다() {
        Car car = new Car("tCar");

        car.forward(4);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차_이름이_5글자를_초과하면_예외가_발생한다() {
        String carName = "testCar";
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("CarName is too long");
    }
}
