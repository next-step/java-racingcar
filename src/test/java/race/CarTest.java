package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void create_자동차를_생성한다() {
        int startStep = 0;
        String name = "dex";

        Car car = Car.create(startStep, name);

        assertThat(car).isEqualTo(Car.create(startStep, name));
    }

    @Test
    void move_자동차_이동조건에_따라_자동차가_이동한다() {
        int startStep = 0;
        String name = "dex";

        Car car = Car.create(startStep, name);
        car.moveBy(new ForwardCarMoveRule());

        assertThat(car).isEqualTo(Car.create(startStep + 1, name));
    }

    @Test
    void move_자동차_이동조건을_만족하지_않으면_자동차가_이동하지_않는다() {
        int startStep = 0;
        String name = "dex";

        Car car = Car.create(startStep, name);
        car.moveBy(new HoldCarMoveRule());

        assertThat(car).isEqualTo(Car.create(startStep, name));
    }
}

