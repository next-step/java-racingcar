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
        this.car = new Car("car", 2);
    }

    @Nested
    class move_메서드는 {

        @Nested
        class number가_4미만이_주어질경우 {
            @ParameterizedTest
            @ValueSource(ints = {3})
            void false를_리턴한다(int number) {
                assertThat(car.move(() -> number)).isFalse();
                assertThat(car).isEqualTo(new Car("car", 2));
            }
        }

        @Nested
        class number가_4이상이_주어질경우 {

            @ParameterizedTest
            @ValueSource(ints = {4})
            void true를_리턴한다(int number) {
                assertThat(car.move(() -> number)).isTrue();
                assertThat(car).isEqualTo(new Car("car", 3));
            }
        }

    }

    @Nested
    class toString_메서드는 {

        @Test
        void 이름과_포지션_문자열을_리턴한다() {
            assertThat(car.toString()).isEqualTo("car : --");
        }
    }

    @Nested
    class matchPosition_메서드는 {

        @Nested
        class 같은_포지션이_주어질_경우 {

            @Test
            void true를_리턴한다() {
                assertThat(car.matchPosition(2)).isTrue();
            }
        }

        @Nested
        class 다른_포지션이_주어질_경우 {

            @Test
            void false를_리턴한다() {
                assertThat(car.matchPosition(3)).isFalse();
            }
        }
    }

    @Nested
    class getPosition_메서드는 {

        @Test
        void 현재_포지션을_리턴한다() {
            assertThat(car.getPosition()).isEqualTo(2);
        }
    }
}
