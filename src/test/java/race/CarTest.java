package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void create_자동차를_생성한다() {
        Car car = Car.create(0);

        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    void move_자동차_이동조건에_따라_자동차가_이동한다() {
        int startStep = 0;
        int moveStep = 1;

        Car car = Car.create(startStep);
        int step = car.moveBy(MockCarMoveRule.createThatPassed(), moveStep);
        assertThat(step).isEqualTo(startStep + moveStep);
    }

    @Test
    void move_자동차_이동조건을_만족하지_않으면_자동차가_이동하지_않는다() {
        int startStep = 0;

        Car car = Car.create(startStep);
        int step = car.moveBy(MockCarMoveRule.createThatFailed(), 1);

        assertThat(step).isEqualTo(startStep);
    }
}

