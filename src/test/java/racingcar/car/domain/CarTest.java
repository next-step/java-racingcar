package racingcar.car.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.assertj.core.api.Assertions;
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
    void test1(final int number) {
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
    void test2(final int number) {
        car.move(new RandomInt(10, new Random() {
            @Override
            public int nextInt(int bound) {
                return number;
            }
        }));
        assertThat(car.getPosition()).isZero();
    }
}
