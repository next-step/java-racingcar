package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.view.result.CarMovementResult;
import step4.view.result.CarMovementRoundResult;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CarMovementRoundResultTest {

    @DisplayName("winnerNames 메서드는 최대 거리를 이동한 사람들의 반환한다.")
    @ParameterizedTest
    @MethodSource("roundMovementResults")
    void winnerNames(List<CarMovementResult> results, String[] winnerNames) {
        final CarMovementRoundResult roundResult = CarMovementRoundResult.from(results);

        assertThat(roundResult.winnerNames())
                .containsExactly(winnerNames);
    }

    private static Stream<Arguments> roundMovementResults() {
        return Stream.of(
                arguments(
                        List.of(
                                new CarMovementResult("a", 1),
                                new CarMovementResult("b", 2),
                                new CarMovementResult("c", 3)
                        ),
                        new String[]{"c"}
                ),
                arguments(
                        List.of(
                                new CarMovementResult("a", 3),
                                new CarMovementResult("b", 3),
                                new CarMovementResult("c", 3)
                        ),
                        new String[]{"a", "b", "c"}
                ),
                arguments(
                        List.of(
                                new CarMovementResult("a", 0),
                                new CarMovementResult("b", 0),
                                new CarMovementResult("c", 0)
                        ),
                        new String[]{"a", "b", "c"}
                )
        );
    }
}
