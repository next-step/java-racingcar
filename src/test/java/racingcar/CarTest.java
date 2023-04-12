package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
class CarTest {

    @Test
    void 자동차의_초기_위치값은_0이다() {
        Car car = new Car();

        int location = car.location();

        Assertions.assertThat(location).isZero();
    }

    @Nested
    class move_메소드는 {
        @Test
        void 인자로_4_이상의_값을_전달받을경우_자신의_상태를_1_증가시킨다() {
            Car car = new Car();
            int beforeLocation = car.location();

            car.move(4);
            int afterLocation = car.location();

            Assertions.assertThat(afterLocation).isEqualTo((beforeLocation + 1));
        }

        @Test
        void 인자로_4_미만의_값을_전달받을경우_정지한다() {
            Car car = new Car();
            int beforeLocation = car.location();

            car.move(3);
            int afterLocation = car.location();

            Assertions.assertThat(afterLocation).isEqualTo(beforeLocation);
        }
    }

}