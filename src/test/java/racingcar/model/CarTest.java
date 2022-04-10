package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @Nested
    class move_메서드는 {

        @Nested
        class number가_4미만이_주어질경우 {

            @ParameterizedTest
            @ValueSource(ints = {3})
            void false를_리턴한다(int number) {
                assertThat(car.move(() -> number)).isFalse();
            }
        }

        @Nested
        class number가_4이상이_주어질경우 {

            @ParameterizedTest
            @ValueSource(ints = {4})
            void true를_리턴한다(int number) {
                assertThat(car.move(() -> number)).isTrue();
            }
        }

    }

    @Nested
    class getPosition_메서드는 {

        @Test
        void 현재_position을_리턴한다() {
            assertThat(car.getPosition()).isEqualTo(0);

            car.move(() -> Car.MOVABLE_NUMBER);
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }
}
