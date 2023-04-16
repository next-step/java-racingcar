package basicgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTryCounterTest {
    CarTryCounter carTryCounter;
    private static final int ZERO = 0;
    private static final int AUTO_INCREMENT_VALUE = 1;

    @BeforeEach
    void init() {
        carTryCounter = new CarTryCounter(ZERO);
    }

    @Test
    @DisplayName("autoIncrement 테스트 Success")
    void autoIncrementSuccess() {
        var currentCount = carTryCounter.getValue();
        carTryCounter.autoIncrement();
        var actualAfterCount = carTryCounter.getValue();
        var expectedAfterCount = currentCount + AUTO_INCREMENT_VALUE;

        assertThat(actualAfterCount).isEqualTo(expectedAfterCount);
    }

    @DisplayName("get Value 테스트 Success")
    @MethodSource("getValueTestArguments")
    @ParameterizedTest
    void getValueTestSuccess(int tryCount, int expectedCountValue) {

        for (int i = 0; i < tryCount; i++) {
            carTryCounter.autoIncrement();
        }

        assertThat(carTryCounter.getValue()).isEqualTo(expectedCountValue);
    }

    public static Stream<Arguments> getValueTestArguments() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 4),
                Arguments.of(5, 5),
                Arguments.of(6, 6),
                Arguments.of(7, 7),
                Arguments.of(8, 8),
                Arguments.of(9, 9)
        );
    }


}