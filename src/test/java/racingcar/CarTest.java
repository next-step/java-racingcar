package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarTest {
    private final String defaultName = "horse";

    @Test
    void 자동차의_초기_위치값은_0이다() {
        Car car = Car.of(defaultName);

        int location = car.location();

        assertThat(location).isZero();
    }

    @Nested
    class move_메소드는 {
        @Test
        void 인자로_4_이상의_값을_전달받을경우_자신의_상태를_1_증가시킨다() {
            Car car = Car.of(defaultName);
            int beforeLocation = car.location();

            car.moveDependingOn(4);
            int afterLocation = car.location();

            assertThat(afterLocation).isEqualTo((beforeLocation + 1));
        }

        @Test
        void 인자로_4_미만의_값을_전달받을경우_정지한다() {
            Car car = Car.of(defaultName);
            int beforeLocation = car.location();

            car.moveDependingOn(3);
            int afterLocation = car.location();

            assertThat(afterLocation).isEqualTo(beforeLocation);
        }
    }

    @Nested
    class 생성자_메서드는 {
        @Test
        void 다섯글자_를_초과하는_이름을_전달받는경우_생성에_실패한다() {
            String invalidName = "123456";

            Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                    .isThrownBy(() -> Car.of(invalidName));
        }
    }

}
