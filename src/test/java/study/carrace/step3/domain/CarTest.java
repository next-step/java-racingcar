package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 자동차_전진_성공() {
        // given
        Car car = new Car(createMockRandomIntegerGenerator(1), 0);

        // when
        car.moveOrStop();

        // then
        assertThat(car.getMoveStatus()).containsExactly(true);
    }

    @Test
    void 자동차_멈춤() {
        // given
        Car car = new Car(createMockRandomIntegerGenerator(0), 1);

        // when
        car.moveOrStop();

        // then
        assertThat(car.getMoveStatus()).containsExactly(false);
    }

    private RandomIntegerGenerator createMockRandomIntegerGenerator(int expected) {
        return () -> expected;
    }
}