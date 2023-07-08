package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤값이 4 이상일 경우 1칸 전진한다.")
    void move_givenMoreThan4_moveOneStep(final int number) {
        car.move(new RandomInt(10, new Random() {
            @Override
            public int nextInt(int bound) {
                return number;
            }
        }));
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤값이 3 이하일 경우 움직이지 않는다.")
    void move_givenBelowThan3_doNotMove(final int number) {
        car.move(new RandomInt(10, new Random() {
            @Override
            public int nextInt(int bound) {
                return number;
            }
        }));
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("position 값이 동일하면 참을 반환한다.")
    void matchPosition_givenEqualValue_returnTrue() {
        assertThat(car.matchPosition(0)).isTrue();
    }

    @Test
    @DisplayName("두 Car 객체의 position 을 비교할 때, 더 큰 position 값을 반환한다.")
    void getMaxPosition_givenOtherPosition_returnBiggerPosition() {
        assertThat(car.getMaxPosition(1)).isEqualTo(1);
    }
}

