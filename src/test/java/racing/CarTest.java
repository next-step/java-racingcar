package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class CarTest {
    static final int MOVE_THRESHOLD = 4;

    @ParameterizedTest
    @MethodSource("testData")
    @DisplayName("자동차는 주사위의 값이 MOVE_THRESHOLD값의 이상일 때만 전진한다.")
    void moveOnceTest(int diceValue, boolean expected) {
        // given
        var car = new Car();

        // when
        car.move(diceValue);

        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(expected ? 1 : 0);
    }

    static Stream<Arguments> testData() {
        return IntStream.rangeClosed(0, 9)
                .mapToObj(it -> Arguments.of(it, it >= MOVE_THRESHOLD));
    }
}
