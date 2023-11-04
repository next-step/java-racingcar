package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.MovingStrategy;

class CarTest {

    @Test
    void 자동차를_생성하면_처음_거리는_0이다() {
        MovingStrategy movingStrategy = new TestMovingStrategy(3);
        MovingValidator movingValidator = new MovingValidator(movingStrategy);
        Car actual = new Car(movingValidator);
        Car expected = new Car(new MovingDistance(), movingValidator);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차는_4에서_9_사이에서는_움직인다다() {

        assertAll(
            () -> {
                MovingStrategy movingStrategy = new TestMovingStrategy(4);
                MovingValidator movingValidator = new MovingValidator(movingStrategy);
                Car actual = new Car(movingValidator);
                actual.move();
                Car expected = new Car(new MovingDistance(1), movingValidator);

                assertThat(actual).isEqualTo(expected);
            },
            () -> {
                MovingStrategy movingStrategy = new TestMovingStrategy(9);
                MovingValidator movingValidator = new MovingValidator(movingStrategy);
                Car actual = new Car(movingValidator);
                actual.move();
                Car expected = new Car(new MovingDistance(1), movingValidator);

                assertThat(actual).isEqualTo(expected);
            }
        );

    }

    @Test
    void 자동차는_0에서_3_사이에서는_움직일_수_없다() {

        assertAll(
            () -> {
                MovingStrategy movingStrategy = new TestMovingStrategy(0);
                MovingValidator movingValidator = new MovingValidator(movingStrategy);
                Car actual = new Car(movingValidator);
                actual.move();
                Car expected = new Car(new MovingDistance(0), movingValidator);

                assertThat(actual).isEqualTo(expected);
            },
            () -> {
                MovingStrategy movingStrategy = new TestMovingStrategy(3);
                MovingValidator movingValidator = new MovingValidator(movingStrategy);
                Car actual = new Car(movingValidator);
                actual.move();
                Car expected = new Car(new MovingDistance(0), movingValidator);

                assertThat(actual).isEqualTo(expected);
            }
        );

    }

    @Test
    void 자동차가_이동한_거리를_표출_할_수_있다() {
        MovingStrategy movingStrategy = new TestMovingStrategy(4);
        MovingValidator movingValidator = new MovingValidator(movingStrategy);
        Car car = new Car(movingValidator);
        car.move();
        MovingDistance actual = car.movingDistance();
        MovingDistance expected = new MovingDistance(1);

        assertThat(actual).isEqualTo(expected);
    }

}
