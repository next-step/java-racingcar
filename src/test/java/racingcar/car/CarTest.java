package racingcar.car;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarTest {
    private final String defaultName = "horse";

    @Test
    void 자동차의_초기_위치값은_0이다() {
        Car car = new Car(defaultName);

        int location = car.location();

        assertThat(location).isZero();
    }

    @Nested
    class move_메소드는 {
        @Test
        void 내부적으로_생성되는_랜덤값에_따라_1_전진하거나_기존위치에_머무른다() {
            Car car = new Car(defaultName);

            int beforeLocation = car.location();

            car.move();

            int currentLocation = car.location();
            Condition<Integer> moved = new Condition(position -> position.equals(beforeLocation + 1), "move forward");
            Condition<Integer> stay = new Condition(position -> position.equals(beforeLocation), "stay");

            Assertions.assertThat(currentLocation)
                    .is(anyOf(moved, stay));
        }
    }

    @Nested
    class 생성자_메서드는 {
        @Test
        void 다섯글자_를_초과하는_이름을_전달받는경우_생성에_실패한다() {
            String invalidName = "123456";

            Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> new Car(invalidName));
        }
    }

    @Nested
    class isWinner_메서드는 {
        @Test
        void 현재까지_자동차들의_최대_위치값이_0인경우_0인위치의_자동차는_우승자다() {
            Car carLocatedOnZero = new Car(defaultName);

            Assertions.assertThat(carLocatedOnZero.isWinner(0))
                    .isTrue();
        }
    }

    @Nested
    class max_메서드는 {
        @Test
        void 자신의_위치와_비교해_max_를_리턴한다() {
            int carLocation = 3;

            Car car = new Car(defaultName, carLocation);
            int max = car.maxLocation(carLocation - 1);

            assertThat(max).isEqualTo(carLocation);
        }
    }
}
