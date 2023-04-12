package game.domain;

import game.util.NumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 자동차 기능
 * <pre>
 *     - 자동차는 전진 또는 멈출 수 있다.
 *     - 자동차는 엔진과 위치를 갖는다.
 *     - 자동차는 위치정보를 반환한다.
 * </pre>
 */
class CarTest {

    @Test
    @DisplayName("자동차는 NumberGenerator 가 4 이상을 반환하면 position 이 증가합니다.")
    void test1() {
        Car car = new Car("test", new MovableNumberGenerator());
        car.drive();
        assertThat(car.position()).isSameAs(1);
    }

    @Test
    @DisplayName("자동차는 NumberGenerator 가 3 이하를 반환하면 position 이 증가하지 않습니다.")
    void test2() {
        Car car = new Car("test", new NonMovableNumberGenerator());
        car.drive();
        assertThat(car.position()).isZero();
    }

    @Test
    @DisplayName("자동차는 5글자를 초과하는 이름을 가질 수 없습니다.")
    void test3() {
        assertThatThrownBy(() -> new Car("testCar", new NonMovableNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }


    static class MovableNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 5;
        }
    }

    static class NonMovableNumberGenerator implements NumberGenerator {
        @Override
        public int generate() {
            return 3;
        }
    }
}