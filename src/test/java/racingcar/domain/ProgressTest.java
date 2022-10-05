package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProgressTest {
    @DisplayName("시도횟수만큼 재시도 하였다면 true 를 리턴하고 아니라면 false 를 리턴한다")
    @ParameterizedTest
    @MethodSource("finishSet")
    void isFinish(int tryCount, int proceedCount, boolean expected) {
        Progress progress = new Progress(tryCount);
        for (int count = 0; count < proceedCount; count++) {
            progress = progress.proceed();
        }
        assertThat(progress.isFinish()).isEqualTo(expected);
    }
    
    private static Stream<Arguments> finishSet() {
        return Stream.of(
            Arguments.arguments(3, 2, false),
            Arguments.arguments(0, 0, true),
            Arguments.arguments(3, 3, true),
            Arguments.arguments(5, 0, false)
        );
    }
}
