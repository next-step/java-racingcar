package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.strategy.MovingStrategy;

class CarTest {

    @Test
    void 자동차를_생성하면_처음_거리는_0이다() {
        MovingStrategy movingStrategy = new TestMovingStrategy(3);
        MovingValidator movingValidator = new MovingValidator(movingStrategy);

        Car actual = new Car(new CarName("pobi"), movingValidator);
        Car expected = new Car(new CarName("pobi"), new Distance(), movingValidator);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "자동차는 {0}에서는 움직인다")
    @CsvSource({"4, 1", "9, 1"})
    void 자동차는_4에서_9_사이에서는_움직인다(int movingValue, int movingDistance) {
        MovingStrategy movingStrategy = new TestMovingStrategy(movingValue);
        MovingValidator movingValidator = new MovingValidator(movingStrategy);
        Car actual = new Car(new CarName("pobi"), movingValidator);

        actual.move();

        Car expected = new Car(new CarName("pobi"), new Distance(movingDistance),
            movingValidator);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest(name = "자동차는 {0}에서 움직일 수 없다")
    @CsvSource({"0, 0", "3, 0"})
    void 자동차는_0에서_3_사이에서는_움직일_수_없다(int movingValue, int movingDistance) {
        MovingStrategy movingStrategy = new TestMovingStrategy(movingValue);
        MovingValidator movingValidator = new MovingValidator(movingStrategy);
        Car actual = new Car(new CarName("pobi"), movingValidator);

        actual.move();

        Car expected = new Car(new CarName("pobi"), new Distance(movingDistance),
            movingValidator);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차가_이동한_거리를_표출_할_수_있다() {
        MovingStrategy movingStrategy = new TestMovingStrategy(4);
        MovingValidator movingValidator = new MovingValidator(movingStrategy);
        Car car = new Car(new CarName("pobi"), movingValidator);
        car.move();

        Distance actual = car.movingDistance();
        Distance expected = new Distance(1);

        assertThat(actual).isEqualTo(expected);
    }

}
